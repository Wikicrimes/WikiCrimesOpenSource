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
package org.wikicrimes.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.wikicrimes.model.BaseObject;
import org.wikicrimes.model.Confirmacao;
import org.wikicrimes.model.Crime;
import org.wikicrimes.model.EntidadeCertificadora;
import org.wikicrimes.model.Razao;
import org.wikicrimes.model.TipoArmaUsada;
import org.wikicrimes.model.TipoCrime;
import org.wikicrimes.model.TipoLocal;
import org.wikicrimes.model.TipoPapel;
import org.wikicrimes.model.TipoRegistro;
import org.wikicrimes.model.TipoTransporte;
import org.wikicrimes.model.TipoVitima;

public interface CrimeService extends GenericCrudService {

	public List<BaseObject> getTipoLocalAll();
	public TipoLocal getTipoLocal(Long id);
	public Crime getCrime(String chave);
	public List<BaseObject> getTipoArmaUsadaAll();
	public TipoArmaUsada getTipoArmaUsada(Long id);
	public List<BaseObject> getTipoRegistroAll();
	public TipoRegistro getTipoRegistro(Long id);
	public List<BaseObject> getTipoPapelAll();
	public TipoPapel getTipoPapel(Long id);
	public List<BaseObject> getTipoCrimeAll();
	public TipoCrime getTipoCrime(Long id);
	public List<BaseObject> getTipoTransporteAll();
	public TipoTransporte getTipoTransporte(Long id);
	public List<BaseObject> getEntidadeCertificadoraAll();
	public EntidadeCertificadora getEntidadeCertificadora(Long id);
	public List<BaseObject> findTipoVitimaByTipoCrime(Long tipoCrime);
	public List<BaseObject> findTipoLocalByTipoVitima(Long tipoVitima);
	public List<BaseObject> getTipoVitimaAll();
	public TipoVitima getTipoVitima(Long id);
	public List<BaseObject> filter(Map parameters);
	public List<BaseObject> filterIncludeReasons(Map parameters);
	public void atualizaContador(Boolean tipo, Crime crime);
	public void atualizaVisualizacoes(Crime crime);
	public void atualizaContadorCometarios(Crime crime);
	public int getQuantidadeCrimesRegistrados();
	public int getQuantidadeCrimesRegistradosAtivos();
	public List<Crime> getByUser(Long idUsuario);
	public List<Crime> getCrimesByTipoPaginado(Long idTipoCrime, Long fr, Long mr);
	public List<Crime> getCrimesSemEstatisticas();
	public Integer getQtdCrimesByTipo(Long idTipoCrime);
	public Integer getQtdCrimesByDateInterval(int tipoCrime, String dataInicio,String dataFim);
	public Integer getQtdCrimesByDateIntervalPais(final int tipoCrime,final String dataInicio, final String dataFim,final String siglaPais);
	public Integer getQtdCrimesByDateIntervalEstado(final int tipoCrime,final String dataInicio, final String dataFim,final String siglaEstado);
	public Integer getQtdCrimesByDateIntervalCidade(final int tipoCrime,final String dataInicio, final String dataFim,final String nomeCidade);
	public void updateCrimesSemChave();
	public List<BaseObject> listarRazoes();
	public boolean insert(BaseObject bo , List<Razao> razoes);
	public List<Crime> pesquisarCrime(Crime crime);
	public List<Crime> getCrimesMaisVistos();
	public List<Crime> getCrimesMaisComentados();
	public List<Crime> getCrimesMaisConfirmados();
	public void update(Crime crime, Set<Confirmacao> confirmacoes, List<Razao> razoes);
	
	public StringBuilder getCrimesInRadius(double latitude, double longitude, double raio,long dataIni, long dataFim, double credibilidadeMin, double credibilidadeMax);
	
	public Map<String,Integer> numeroCrimesArea(double latitude, double longitude, double raio,long dataIni, long dataFim);
	
	public boolean realizaAtivacao(String codApp);
	
}
