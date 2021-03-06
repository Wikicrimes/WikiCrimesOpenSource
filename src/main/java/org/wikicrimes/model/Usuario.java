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
package org.wikicrimes.model;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

public class Usuario extends BaseObject {

	private static final long serialVersionUID = 3257568390917667126L;

	private Long idUsuario;

	private String primeiroNome;
	private String ultimoNome;
	private String homepage;
	private String email;
	private String confirmacao;
	private String senha;
	private String cidade;
	private String idiomaPreferencial;
	private String receberNewsletter;
	private String estado;
	private String pais;
	private Date aniversario;
	private String ip;
	private String ipAlteracao;
	private Integer sexo;
	private String chaveConfirmacao;
	private Perfil perfil;
	private Double lat;
	private Double lng;
	private Date dataHoraRegistro;
	private Date dataHoraAlteracao;
	private EntidadeCertificadora entidadeCertificadora;
	private Set<UsuarioRedeSocial> redesSociais;
	private String tutorAtivado;
	private String emailAtivo;
	private UsuarioCelular usuarioCelular;
	private Boolean confAutomatica;
	private String externalUrlRpx;
	private String externalToken;
	
	private Set<Reputacao> reputacoes;
	
	private Integer mobileAppAtivacao;
	private String mobileAppID;
	private Long countAtividadeMobile;
	private String celularModel,quantoTempoUsaAppCelular;
	private Boolean usaInternetCelular;

	public final static String TRUE = "1";
	public final static String FALSE = "0";

	public String getChaveConfirmacao() {
		return chaveConfirmacao;
	}

	public void setChaveConfirmacao(String chaveConfirmacao) {
		this.chaveConfirmacao = chaveConfirmacao;
	}

	public Usuario() {
	}

	public Usuario(Long idUsuario) {
		this.setIdUsuario(idUsuario);
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return Returns firstName and lastName
	 */
	public String getNome() {
		return primeiroNome + " " + ultimoNome;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmacao() {
		return confirmacao;
	}

	public void setConfirmacao(String confirmacao) {
		this.confirmacao = confirmacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Usuario)) {
			return false;
		} else {
			Usuario usuario = (Usuario) obj;
			return usuario.getIdUsuario().equals(this.getIdUsuario());
		}

	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Date getDataHoraRegistro() {
		return dataHoraRegistro;
	}

	public void setDataHoraRegistro(Date dataHoraRegistro) {
		this.dataHoraRegistro = dataHoraRegistro;
	}

	public EntidadeCertificadora getEntidadeCertificadora() {
		return entidadeCertificadora;
	}

	public void setEntidadeCertificadora(
			EntidadeCertificadora entidadeCertificadora) {
		this.entidadeCertificadora = entidadeCertificadora;
	}

	public Set<UsuarioRedeSocial> getRedesSociais() {
		return redesSociais;
	}

	public void setRedesSociais(Set<UsuarioRedeSocial> redesSociais) {
		this.redesSociais = redesSociais;
	}

	public String getIdiomaPreferencial() {
		return idiomaPreferencial;
	}

	public void setIdiomaPreferencial(String idiomaPreferencial) {
		this.idiomaPreferencial = idiomaPreferencial;
	}

	public String getReceberNewsletter() {
		return receberNewsletter;
	}

	public void setReceberNewsletter(String receberNewsletter) {
		this.receberNewsletter = receberNewsletter;
	}

	public Date getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}

	public void setDataHoraAlteracao(Date dataHoraAlteracao) {
		this.dataHoraAlteracao = dataHoraAlteracao;
	}

	public String getIpAlteracao() {
		return ipAlteracao;
	}

	public void setIpAlteracao(String ipAlteracao) {
		this.ipAlteracao = ipAlteracao;
	}
	
	public String getTutorAtivado() {
		return tutorAtivado;
	}

	public void setTutorAtivado(String tutorAtivado) {
		this.tutorAtivado = tutorAtivado;
	}

	public String getEmailAtivo() {
		return emailAtivo;
	}

	public void setEmailAtivo(String emailAtivo) {
		this.emailAtivo = emailAtivo;
	}	

	public UsuarioCelular getUsuarioCelular() {
		return usuarioCelular;
	}

	public void setUsuarioCelular(UsuarioCelular usuarioCelular) {
		this.usuarioCelular = usuarioCelular;
	}	

	public Boolean getConfAutomatica() {
		return confAutomatica;
	}

	public void setConfAutomatica(Boolean confAutomatica) {
		this.confAutomatica = confAutomatica;
	}
	
	public Integer getMobileAppAtivacao(){
		return mobileAppAtivacao;
	}
	
	public String getMobileAppID(){
		return mobileAppID;
	}
	
	public void setMobileAppAtivacao(Integer mobileAppAtivacao){
		this.mobileAppAtivacao=mobileAppAtivacao;
	}
	
	public void setMobileAppID(String mobileAppID){
		this.mobileAppID=mobileAppID;
	}

	@Override
	public Usuario clone() {
		try {
			Usuario obj = new Usuario();
			BeanUtils.copyProperties(obj, this);
			return obj;
		} catch (IllegalAccessException e) {
			return null;
		} catch (InvocationTargetException e) {
			return null;
		}
	}

	public Long getCountAtividadeMobile() {
		return countAtividadeMobile;
	}

	public void setCountAtividadeMobile(Long countAtividadeMobile) {
		this.countAtividadeMobile = countAtividadeMobile;
	}

	public String getCelularModel() {
		return celularModel;
	}

	public void setCelularModel(String celularModel) {
		this.celularModel = celularModel;
	}

	public String getQuantoTempoUsaAppCelular() {
		return quantoTempoUsaAppCelular;
	}

	public void setQuantoTempoUsaAppCelular(String quantoTempoUsaAppCelular) {
		this.quantoTempoUsaAppCelular = quantoTempoUsaAppCelular;
	}

	public Boolean getUsaInternetCelular() {
		return usaInternetCelular;
	}

	public void setUsaInternetCelular(Boolean usaInternetCelular) {
		this.usaInternetCelular = usaInternetCelular;
	}

	
	public Set<Reputacao> getReputacoes() {
		return reputacoes;
	}
	public void setReputacoes(Set<Reputacao> reputacoes) {
		this.reputacoes = reputacoes;
	}
	
	public Reputacao getUltimaReputacao() {
		return (Reputacao)reputacoes.toArray()[reputacoes.size()-1];
	}
	
	public String getExternalUrlRpx() {
		return externalUrlRpx;
	}

	public void setExternalUrlRpx(String externalUrlRpx) {
		this.externalUrlRpx = externalUrlRpx;
	}
	
	public String getExternalToken() {
		return externalToken;
	}

	public void setExternalToken(String externalToken) {
		this.externalToken = externalToken;
	}

	@Override
	public String toString() {
		return email;
	}

}


