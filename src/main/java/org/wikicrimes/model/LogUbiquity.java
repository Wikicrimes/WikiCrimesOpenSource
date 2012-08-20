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

public class LogUbiquity extends BaseObject {
		
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 3414465136442220287L;

	private Long idLog;
	
	private Integer idSIA;
	
	private Crime crime;
	
	private Date data;
	
	private String campo;
	
	private String campoAntigo;
	
	private String campoNovo;
	
	public LogUbiquity() {
			}

	public Long getIdLog() {
		return idLog;
	}

	public void setIdLog(Long idLog) {
		this.idLog = idLog;
	}

	public Integer getIdSIA() {
		return idSIA;
	}

	public void setIdSIA(Integer idSIA) {
		this.idSIA = idSIA;
	}

	public Crime getCrime() {
		return crime;
	}

	public void setCrime(Crime crime) {
		this.crime = crime;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getCampoAntigo() {
		return campoAntigo;
	}

	public void setCampoAntigo(String campoAntigo) {
		this.campoAntigo = campoAntigo;
	}

	public String getCampoNovo() {
		return campoNovo;
	}

	public void setCampoNovo(String campoNovo) {
		this.campoNovo = campoNovo;
	}
}