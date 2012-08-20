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


public class Abuso extends BaseObject {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4113425568334062583L;
		
	/**
	 * Vari�veis de Inst�ncia
	 */
	private Long idAbuso;
		
	private Usuario usuario;

	private String ip;
	
	private Date dataHoraRegistro;
	
	private String descricao;
	
	private Crime crime;
	
	private Relato relato;
		
	public Crime getCrime() {
		return crime;
	}

	public void setCrime(Crime crime) {
		this.crime = crime;
	}

	public Relato getRelato() {
		return relato;
	}

	public void setRelato(Relato relato) {
		this.relato = relato;
	}

	public Abuso(Long idAbuso) {
		this.setIdAbuso(idAbuso);
	}

	public Abuso() {
	
	}

	public Long getIdAbuso() {
		return idAbuso;
	}

	public void setIdAbuso(Long idAbuso) {
		this.idAbuso = idAbuso;
	}
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Abuso)) {
			return false;
		} else {
			Abuso ab = (Abuso) obj;
			return ab.getIdAbuso().equals(this.getIdAbuso());
		}

	}
	
	public Date getDataHoraRegistro() {
		return dataHoraRegistro;
	}

	public void setDataHoraRegistro(Date dataHoraRegistro) {
		this.dataHoraRegistro = dataHoraRegistro;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}



}
