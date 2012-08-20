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

public class Credibilidade extends BaseObject{
	
	private static final long serialVersionUID = 132239747965134434L;
	
	
	/** Variables **/
	private Long idCredibilidade;
	private Double credibilidade;
	private Date periodo;
	private Crime crime;

	
	
	/** Constructors **/
	public Credibilidade() { }
	
	public Credibilidade(Long idCredibilidade) {
		this.idCredibilidade = idCredibilidade;
	}
	
	public Credibilidade(Long idCredibilidade, Double credibilidade, Date periodo, Crime crime) 
	{
		this.idCredibilidade = idCredibilidade;
		this.credibilidade = credibilidade;
		this.periodo = periodo;
		this.crime = crime;
	}
	
	
	
	/** Gets and Sets **/
	public Long getIdCredibilidade() {
		return idCredibilidade;
	}
	public void setIdCredibilidade(Long idCredibilidade) {
		this.idCredibilidade = idCredibilidade;
	}
	
	public Double getCredibilidade() {
		return credibilidade;
	}
	public void setCredibilidade(Double credibilidade) {
		this.credibilidade = credibilidade;
	}

	public void setCrime(Crime crime) {
		this.crime = crime;
	}
	public Crime getCrime() {
		return crime;
	}

	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}

	public Date getPeriodo() {
		return periodo;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Credibilidade)) {
			return false;
		} else {
			Credibilidade credibilidade = (Credibilidade) obj;
			return credibilidade.getIdCredibilidade().equals(idCredibilidade);
		}

	}
	
}

