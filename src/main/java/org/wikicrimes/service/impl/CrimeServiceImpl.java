/**
 
    WikiCrimes (http://www.wikicrimes.org) is a project/software that allows posting and accessing criminal occurrences in a digital map.
    The philosophy that drives Wikicrimes is the same as Wikipedia: mass collaboration produces valuable knowledge.
    That is to say, if everybody participates, the criminal mapping will be made collaboratively and everybody
    will leverage crime information digitalized in the map. That is the reason for the slogan "Share crime information. Keep safe!". 
    Wikicrimes is not a project developed by any security institution. 
    In fact it is a project from the citizen to the citizen. 
     
    
    Copyright (C) 2008  Wikinova Solutions (http://www.wikinova.com.br)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/
package org.wikicrimes.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.context.FacesContext;

import org.hibernate.Hibernate;
import org.wikicrimes.dao.CredibilidadeDao;
import org.wikicrimes.dao.CrimeDao;
import org.wikicrimes.dao.EntidadeCertificadoraDao;
import org.wikicrimes.dao.RazaoDao;
import org.wikicrimes.dao.TipoArmaUsadaDao;
import org.wikicrimes.dao.TipoCrimeDao;
import org.wikicrimes.dao.TipoLocalDao;
import org.wikicrimes.dao.TipoPapelDao;
import org.wikicrimes.dao.TipoRegistroDao;
import org.wikicrimes.dao.TipoTransporteDao;
import org.wikicrimes.dao.TipoVitimaDao;
import org.wikicrimes.model.BaseObject;
import org.wikicrimes.model.Confirmacao;
import org.wikicrimes.model.Credibilidade;
import org.wikicrimes.model.Crime;
import org.wikicrimes.model.CrimeRazao;
import org.wikicrimes.model.CrimeVitima;
import org.wikicrimes.model.EntidadeCertificadora;
import org.wikicrimes.model.Razao;
import org.wikicrimes.model.Relato;
import org.wikicrimes.model.RelatoRazao;
import org.wikicrimes.model.TipoArmaUsada;
import org.wikicrimes.model.TipoConfirmacao;
import org.wikicrimes.model.TipoCrime;
import org.wikicrimes.model.TipoLocal;
import org.wikicrimes.model.TipoPapel;
import org.wikicrimes.model.TipoRegistro;
import org.wikicrimes.model.TipoTransporte;
import org.wikicrimes.model.TipoVitima;
import org.wikicrimes.service.ConfirmacaoService;
import org.wikicrimes.service.CrimeService;
import org.wikicrimes.service.EmailService;
import org.wikicrimes.util.Cripto;

public class CrimeServiceImpl extends GenericCrudServiceImpl implements
		CrimeService {

	private TipoArmaUsadaDao tipoArmaUsadaDao;

	private TipoLocalDao tipoLocalDao;

	private TipoCrimeDao tipoCrimeDao;

	private TipoPapelDao tipoPapelDao;

	private TipoRegistroDao tipoRegistroDao;

	private TipoTransporteDao tipoTransporteDao;

	private TipoVitimaDao tipoVitimaDao;
	
	private EntidadeCertificadoraDao entidadeCertificadoraDao;

	private CredibilidadeDao credibilidadeDao;
	
	private ConfirmacaoService confirmacaoService;
	
	private CrimeDao crimeDao;
	
	private RazaoDao razaoDao;
	
	private EmailService emailService;

	
	public boolean insert(BaseObject bo , List<Razao> razoes)
	{
		setCacheEstatisticas((Crime)bo, razoes);
		
		boolean retorno = insert(bo);
		
		for (Razao razao : razoes) {
			CrimeRazao cr = new CrimeRazao();
			cr.setRazao(razao);
			cr.setCrime((Crime)bo);
			razaoDao.save(cr);
		}
		
		
		return retorno;
	}
	
	private void setCacheEstatisticas(Crime crime, List<Razao> razoes) {
		StringBuilder str = new StringBuilder();
		str.append(crime.getTipoCrime().getIdTipoCrime());
		str.append("|");
		str.append(crime.getTipoVitima().getIdTipoVitima());
		str.append("|");
		for(Razao r : razoes) {
			str.append(r.getIdRazao());
			str.append(",");
		}
		str.delete(str.length()-1, str.length());
		crime.setCacheEstatisticas(str.toString());
	}

	public boolean insert(BaseObject bo) 
	{
		Crime crime = (Crime) bo;
		
		if (getDao().save(crime)) 
		{
			crime.setChave(Cripto.criptografar(crime.getIdCrime().toString()+crime.getDataHoraRegistro().toString()));
			
			if(crime.getUsuario().getConfAutomatica()){
				crime.setConfirmacoesPositivas(new Long(1));					
			}
			getDao().save(crime);
			
			//se nao for certificador enviar emails para as indicacoes
			//if (!crime.getUsuario().getPerfil().equals(Perfil.CERTIFICADOR)){
				Set<Confirmacao> confirmacoes = crime.getConfirmacoes();					
				
				if(confirmacoes!=null)
					criarConfirmacoes(crime, confirmacoes);
			//}
			criarCredibilidade(crime);
				
			return true;
		}
		return false;
	}
	
	private void criarConfirmacoes(Crime crime, Set<Confirmacao> confirmacoes)
	{
		for (Confirmacao confirmacao : confirmacoes) 
		{
			confirmacao.setCrime(crime);
			
			if(crime.getUsuario().getConfAutomatica())
			{
				confirmacao.setConfirma(true);
				TipoConfirmacao tipCon = new TipoConfirmacao();
				tipCon.setIdTipoConfirmacao(new Long(1));
				confirmacao.setTipoConfirmacao(tipCon);
			}
			confirmacaoService.insert(confirmacao);
		}
		
		if(!crime.getUsuario().getConfAutomatica())
		{
			if(crime.getRegistradoPelaApi()!=null && !crime.getRegistradoPelaApi().equalsIgnoreCase("1"))
				emailService.sendMailConfirmation(crime,FacesContext.getCurrentInstance().getViewRoot().getLocale().toString());
			else
				emailService.sendMailConfirmation(crime,crime.getUsuario().getIdiomaPreferencial());
		}
	}
	
	private void criarCredibilidade(Crime crime)
	{
		double cred = crime.getUsuario().getUltimaReputacao().getReputacao();
		
		Credibilidade credibilidade = new Credibilidade(null, cred, new Date(), crime);
		
//		TODO Manter lista de Credibilidades para futura atualizacao
//		Set<Credibilidade> credibilidades = crime.getCredibilidades();
//		
//		if (credibilidades == null)
//			credibilidades = new HashSet<Credibilidade>();
//		
//		credibilidades.add(credibilidade);
//		crime.setCredibilidades(credibilidades);
		
		crime.setUltimaCredibilidade(credibilidade.getCredibilidade());
		credibilidadeDao.save(credibilidade);
	}
	
	
	public void update(Crime crime, Set<Confirmacao> confirmacoes, List<Razao> razoes){
		update(crime);
		Crime crimeTemp = new Crime();
		crimeTemp.setDescricao(crime.getDescricao());
		crimeTemp.setChave(crime.getChave());
		crimeTemp.setConfirmacoes(confirmacoes);
		crimeTemp.setTipoCrime(crime.getTipoCrime());
		Hibernate.initialize(crime.getTipoLocal().getTipoVitima());
		crimeTemp.setTipoLocal(crime.getTipoLocal());
		crimeTemp.setTipoVitima(crime.getTipoVitima());
	
		Hibernate.initialize(crime.getUsuario());
		crimeTemp.setUsuario(crime.getUsuario());
		//crime.setConfirmacoes(confirmacoes);
		for (Iterator<Confirmacao> iterator = confirmacoes.iterator(); iterator.hasNext();) {
			Confirmacao conf = (Confirmacao) iterator.next();
			super.update(conf);
			
			
		}
		for (Iterator<Razao> iterator = razoes.iterator(); iterator.hasNext();) {
			Razao razao = (Razao) iterator.next();
			CrimeRazao crimeRazao = new CrimeRazao();
			crimeRazao.setRazao(razao);
			crimeRazao.setCrime(crime);
			super.update(crimeRazao);
		}	
		emailService.sendMailConfirmation(crimeTemp,FacesContext.getCurrentInstance().getViewRoot().getLocale().toString());
	}
	
	public int getQuantidadeCrimesRegistrados(){
		return crimeDao.getAll().size();
	}
	
	public int getQuantidadeCrimesRegistradosAtivos(){
		return crimeDao.getQTDCrimesAtivos().intValue();
	}
	public List<BaseObject> getTipoArmaUsadaAll() {
		return tipoArmaUsadaDao.getAll();
	}

	public List<BaseObject> getTipoCrimeAll() {
		return tipoCrimeDao.getAll();
	}

	public List<BaseObject> getTipoLocalAll() {
		return tipoLocalDao.getAll();
	}

	public List<BaseObject> getTipoPapelAll() {
		return tipoPapelDao.getAll();
	}

	public List<BaseObject> getTipoRegistroAll() {
		return tipoRegistroDao.getAll();
	}

	public List<BaseObject> getTipoTransporteAll() {
		return tipoTransporteDao.getAll();
	}

	public List<BaseObject> getTipoVitimaAll() {
		return tipoVitimaDao.getAll();
	}
	public List<BaseObject> getEntidadeCertificadoraAll() {
		return entidadeCertificadoraDao.getAll();
	}

	public List<Crime> getByUser(Long idUsuario) {
		return crimeDao.getByUser(idUsuario);
	}
	
	public List<Crime> getCrimesByTipoPaginado(Long idTipoCrime, Long fr, Long mr) {
		return crimeDao.getByTipoPaginado(idTipoCrime, fr, mr);
	}
	
	public List<BaseObject> findTipoLocalByTipoVitima(Long idTipoVitima) {
		return tipoLocalDao.findTipoLocalByTipoVitima(idTipoVitima);
	}

	public List<BaseObject> findTipoVitimaByTipoCrime(Long idTipoCrime) {
		TipoCrime tipoCrime = new TipoCrime(idTipoCrime);

		CrimeVitima crimeVitima = new CrimeVitima();
		crimeVitima.setTipoCrime(tipoCrime);
		return tipoVitimaDao.findTipoVitimaBytTipoCrime(crimeVitima);
	}

	/*
	 * GETS E SETS
	 */
	public TipoArmaUsadaDao getTipoArmaUsadaDao() {
		return tipoArmaUsadaDao;
	}

	public void setTipoArmaUsadaDao(TipoArmaUsadaDao tipoArmaUsadaDao) {
		this.tipoArmaUsadaDao = tipoArmaUsadaDao;
	}

	public TipoLocalDao getTipoLocalDao() {
		return tipoLocalDao;
	}

	public void setTipoLocalDao(TipoLocalDao tipoLocalDao) {
		this.tipoLocalDao = tipoLocalDao;
	}

	public TipoCrimeDao getTipoCrimeDao() {
		return tipoCrimeDao;
	}

	public void setTipoCrimeDao(TipoCrimeDao tipoCrimeDao) {
		this.tipoCrimeDao = tipoCrimeDao;
	}

	public TipoPapelDao getTipoPapelDao() {
		return tipoPapelDao;
	}

	public void setTipoPapelDao(TipoPapelDao tipoPapelDao) {
		this.tipoPapelDao = tipoPapelDao;
	}

	public TipoRegistroDao getTipoRegistroDao() {
		return tipoRegistroDao;
	}

	public void setTipoRegistroDao(TipoRegistroDao tipoRegistroDao) {
		this.tipoRegistroDao = tipoRegistroDao;
	}

	public TipoTransporteDao getTipoTransporteDao() {
		return tipoTransporteDao;
	}

	public void setTipoTransporteDao(TipoTransporteDao tipoTransporteDao) {
		this.tipoTransporteDao = tipoTransporteDao;
	}

	public TipoArmaUsada getTipoArmaUsada(Long id) {
		return (TipoArmaUsada) tipoArmaUsadaDao.get(id);
	}

	public TipoCrime getTipoCrime(Long id) {
		TipoCrime tipoCrimetemp=(TipoCrime) tipoCrimeDao.get(id);
		Hibernate.initialize(tipoCrimetemp.getDescricao());
		return tipoCrimetemp;
	}

	public TipoLocal getTipoLocal(Long id) {
		TipoLocal tipoLocalTemp = (TipoLocal) tipoLocalDao.get(id);
		Hibernate.initialize(tipoLocalTemp.getTipoVitima());
		return tipoLocalTemp;
	}

	public TipoPapel getTipoPapel(Long id) {
		return (TipoPapel) tipoPapelDao.get(id);
	}

	public TipoRegistro getTipoRegistro(Long id) {
		return (TipoRegistro) tipoRegistroDao.get(id);
	}

	public TipoTransporte getTipoTransporte(Long id) {
		return (TipoTransporte) tipoTransporteDao.get(id);
	}
	
	public EntidadeCertificadora getEntidadeCertificadora(Long id) {
		return (EntidadeCertificadora) entidadeCertificadoraDao.get(id);
	}


	public TipoVitimaDao getTipoVitimaDao() {
		return tipoVitimaDao;
	}
	public TipoVitima getTipoVitima(Long id) {
		return (TipoVitima) tipoVitimaDao.get(id);
	}

	public void setTipoVitimaDao(TipoVitimaDao tipoVitimaDao) {
		this.tipoVitimaDao = tipoVitimaDao;
	}

	public ConfirmacaoService getConfirmacaoService() {
		return confirmacaoService;
	}

	public void setConfirmacaoDao(ConfirmacaoService confirmacaoService) {
		this.confirmacaoService = confirmacaoService;
	}

	public void setConfirmacaoService(ConfirmacaoService confirmacaoService) {
		this.confirmacaoService = confirmacaoService;
	}

	public List<BaseObject> filter(Map parameters) {
		return crimeDao.filter(parameters);
	}
	
	public List<BaseObject> filterIncludeReasons(Map parameters) {
		List<BaseObject> crimes = crimeDao.filter(parameters);
		for(BaseObject o : crimes) {
			if(o instanceof Crime) {
				Crime c = (Crime)o;
				for(CrimeRazao cr : c.getRazoes()) {
					Hibernate.initialize(cr);
					Hibernate.initialize(cr.getRazao().getDescricao());
				}
			}else if(o instanceof Relato) {
				Relato r = (Relato)o;
				for(RelatoRazao cr : r.getRazoes()) {
					Hibernate.initialize(cr);
					Hibernate.initialize(cr.getRazao());
					Hibernate.initialize(cr.getRazao().getDescricao());
				}
			}
		}
		return crimes;
	}

	public CrimeDao getCrimeDao() {
		return crimeDao;
	}

	public void setCrimeDao(CrimeDao crimeDao) {
		this.crimeDao = crimeDao;
	}
	/*
	 * metodo que atualiza contador da quantidade de confirmacoes de um crime
	 * leo
	 */
	public void atualizaContador(Boolean tipo, Crime crime){
		this.crimeDao.incrementaContador(tipo, crime.getIdCrime());
	}
	
	/*
	 * metodo que atualiza contador da quantidade de visualizacoes de um crime
	 * leo
	 */
	public void atualizaVisualizacoes(Crime crime){
		this.crimeDao.incrementaView(crime.getIdCrime());
	}
	
	/*
	 * metodo que atualiza contador da quantidade de confirmacoes de um crime
	 * leo
	 */
	public void atualizaContadorCometarios(Crime crime){
		this.crimeDao.atualizaContadorCometarios(crime.getChave());
	}
	

	public List<Crime> getCrimesSemEstatisticas() {
		return this.crimeDao.getCrimesSemEstatisticas();
		
	}

	public void setEmailService(EmailService emailService) {
        this.emailService=emailService;
    }
	
	
	public Integer getQtdCrimesByDateInterval(int tipoCrime, String dataInicio, String dataFim){
		return this.crimeDao.getQtdCrimesByDateInterval(tipoCrime, dataInicio, dataFim);
	}
	
	public Integer getQtdCrimesByDateIntervalPais(final int tipoCrime, final String dataInicio, final String dataFim, final String siglaPais){
		return this.crimeDao.getQtdCrimesByDateIntervalPais(tipoCrime, dataInicio, dataFim, siglaPais);
	}
	
	public Integer getQtdCrimesByDateIntervalEstado(final int tipoCrime, final String dataInicio, final String dataFim, final String siglaEstado){
		return this.crimeDao.getQtdCrimesByDateIntervalEstado(tipoCrime, dataInicio, dataFim, siglaEstado);
	}
	
	public Integer getQtdCrimesByDateIntervalCidade(final int tipoCrime, final String dataInicio, final String dataFim, final String nomeCidade){
		return this.crimeDao.getQtdCrimesByDateIntervalCidade(tipoCrime, dataInicio, dataFim, nomeCidade);
	}
	//atualiza crimes sem chave criptografadas baseado no id e na data de registro
	public void updateCrimesSemChave() {
				
		List<Crime> crimes =this.getCrimeDao().getCrimesSemChave();
		for (Crime c : crimes) {
				if (c.getDataHoraRegistro() !=null)
					c.setChave(Cripto.criptografar(c.getIdCrime().toString()+c.getDataHoraRegistro().toString()));
				else
					c.setChave(Cripto.criptografar(c.getIdCrime().toString()+c.getData().toString()));
				this.getCrimeDao().save(c);
		}

	}


	public Crime getCrime(String chave) {
			Crime c= new Crime();
			c.setChave(chave);
			List<Crime> list = crimeDao.getCrime(chave);
			if(list.size() == 0){
				c.setStatus(new Long(1));
				return c;
			}
			c = (Crime)list.get(0);
			Hibernate.initialize(c.getTipoCrime());
			Hibernate.initialize(c.getUsuario());
			Hibernate.initialize(c.getTipoVitima());
			if (list.size() != 0)
				return c;
			else
				return null;
		
	}
	
	public Crime get(Long id){
		Crime temp=(Crime) this.getDao().get(id);
		Hibernate.initialize(temp.getTipoCrime());
		Hibernate.initialize(temp.getUsuario());
		Hibernate.initialize(temp.getTipoVitima());
		return temp;
	}


	public EntidadeCertificadoraDao getEntidadeCertificadoraDao() {
		return entidadeCertificadoraDao;
	}




	public void setEntidadeCertificadoraDao(
			EntidadeCertificadoraDao entidadeCertificadoraDao) {
		this.entidadeCertificadoraDao = entidadeCertificadoraDao;
	}




	public RazaoDao getRazaoDao() {
		return razaoDao;
	}
	
	public List<BaseObject> listarRazoes() {
		// TODO Auto-generated method stub
		return razaoDao.listarRazoes();
	}
	
	public void setRazaoDao(RazaoDao razaoDao) {
		this.razaoDao = razaoDao;
	}

	public List<Crime> pesquisarCrime(Crime crime){
		return crimeDao.pesquisarCrime(crime);
	}

	@Override
	public List<Crime> getCrimesMaisVistos() {
		// TODO Auto-generated method stub
		return crimeDao.getCrimesMaisVistos();
	}

	@Override
	public List<Crime> getCrimesMaisComentados() {
		// TODO Auto-generated method stub
		return crimeDao.getCrimesMaisComentados();
	}

	@Override
	public List<Crime> getCrimesMaisConfirmados() {
		// TODO Auto-generated method stub
		return crimeDao.getCrimesMaisConfirmados();
	}
	
	public Map<String,Integer> numeroCrimesArea(double latitude, double longitude, double raio,long dataIni, long dataFim){
		return crimeDao.contaCrimesArea(latitude, longitude, raio,dataIni, dataFim);
	}

	@Override
	public boolean realizaAtivacao(String codApp) {
		return crimeDao.realizaAtivacao(codApp);
	}

	public void setCredibilidadeDao(CredibilidadeDao credibilidadeDao) {
		this.credibilidadeDao = credibilidadeDao;
	}

	public CredibilidadeDao getCredibilidadeDao() {
		return credibilidadeDao;
	}

	@Override
	public StringBuilder getCrimesInRadius(double latitude, double longitude,
			double raio, long dataIni, long dataFim, double credibilidadeMin, double credibilidadeMax) {
		return crimeDao.getCrimesInRadius(latitude, longitude, raio, dataIni, dataFim, credibilidadeMin, credibilidadeMax);
	}
	
	public Integer getQtdCrimesByTipo(Long idTipoCrime){
		return crimeDao.getQtdCrimesByTipo(idTipoCrime);
	}

}
