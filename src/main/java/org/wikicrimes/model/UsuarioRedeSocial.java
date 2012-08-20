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

import java.util.Date;

public class UsuarioRedeSocial extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5288365278146939204L;
	
	private Long idUsuarioRedeSocial;
	
	private Usuario usuario;
	
	private RedeSocial redeSocial;
	
	private String idUsuarioDentroRedeSocial;
	
	private Integer visualizarCrimes;
	
	private Date dataHoraRegistro;
	
	private String cidade;
	
	private String pais;
	
	private Integer ativarTutor;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getVisualizarCrimes() {
		return visualizarCrimes;
	}

	public void setVisualizarCrimes(Integer visualizarCrimes) {
		this.visualizarCrimes = visualizarCrimes;
	}

	public Long getIdUsuarioRedeSocial() {
		return idUsuarioRedeSocial;
	}

	public void setIdUsuarioRedeSocial(Long idUsuarioRedeSocial) {
		this.idUsuarioRedeSocial = idUsuarioRedeSocial;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public RedeSocial getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(RedeSocial redeSocial) {
		this.redeSocial = redeSocial;
	}

	public Date getDataHoraRegistro() {
		return dataHoraRegistro;
	}

	public void setDataHoraRegistro(Date dataHoraRegistro) {
		this.dataHoraRegistro = dataHoraRegistro;
	}

	public String getIdUsuarioDentroRedeSocial() {
		return idUsuarioDentroRedeSocial;
	}

	public void setIdUsuarioDentroRedeSocial(String idUsuarioDentroRedeSocial) {
		this.idUsuarioDentroRedeSocial = idUsuarioDentroRedeSocial;
	}

	public Integer getAtivarTutor() {
		return ativarTutor;
	}

	public void setAtivarTutor(Integer ativarTutor) {
		this.ativarTutor = ativarTutor;
	}	

}
