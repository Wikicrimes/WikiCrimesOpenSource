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


public class CrimeCelular extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6092736035904683586L;

	private Long idCrime;
	
	private String latitude;

	private String longitude;
	
	private String tipoCrime;
	
	private UsuarioCelular usuarioCelular;

	private String data;
	
	private Date dataHoraRegistro;
	
	private String descricao;
	
	private String turno;
	
	private Long jaImportado;
	
	public Long getIdCrime() {
		return idCrime;
	}

	public void setIdCrime(Long idCrime) {
		this.idCrime = idCrime;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public UsuarioCelular getUsuarioCelular() {
		return usuarioCelular;
	}

	public void setUsuarioCelular(UsuarioCelular usuarioCelular) {
		this.usuarioCelular = usuarioCelular;
	}
		
	public Date getDataHoraRegistro() {
		return dataHoraRegistro;
	}

	public void setDataHoraRegistro(Date dataHoraRegistro) {
		this.dataHoraRegistro = dataHoraRegistro;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getTipoCrime() {
		return tipoCrime;
	}

	public void setTipoCrime(String tipoCrime) {
		this.tipoCrime = tipoCrime;
	}

	public Long getJaImportado() {
		return jaImportado;
	}

	public void setJaImportado(Long jaImportado) {
		this.jaImportado = jaImportado;
	}
	
}
