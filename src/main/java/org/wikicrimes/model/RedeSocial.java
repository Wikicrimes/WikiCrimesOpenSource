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

public class RedeSocial extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9195674846860255605L;
	
	private Long idRedeSocial;
	
	private String dominioRedeSocial;
	
	private String nomeRedeSocial;
	
	private String descricaoRedeSocial;
	
	public RedeSocial(){}
	
	public RedeSocial(String dominioRedeSocial){
		this.setDominioRedeSocial(dominioRedeSocial);
	}

	public Long getIdRedeSocial() {
		return idRedeSocial;
	}

	public void setIdRedeSocial(Long idRedeSocial) {
		this.idRedeSocial = idRedeSocial;
	}

	public String getNomeRedeSocial() {
		return nomeRedeSocial;
	}

	public void setNomeRedeSocial(String nomeRedeSocial) {
		this.nomeRedeSocial = nomeRedeSocial;
	}

	public String getDescricaoRedeSocial() {
		return descricaoRedeSocial;
	}

	public void setDescricaoRedeSocial(String descricaoRedeSocial) {
		this.descricaoRedeSocial = descricaoRedeSocial;
	}

	public String getDominioRedeSocial() {
		return dominioRedeSocial;
	}

	public void setDominioRedeSocial(String dominioRedeSocial) {
		this.dominioRedeSocial = dominioRedeSocial;
	}
	
}
