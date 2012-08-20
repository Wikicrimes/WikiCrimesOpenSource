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

public class CrimeVitima extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5052275238366575211L;

	private TipoCrime tipoCrime;
	private TipoVitima tipoVitima;

	public CrimeVitima(TipoCrime tipoCrime, TipoVitima tipoVitima) {
		this.tipoCrime = tipoCrime;
		this.tipoVitima = tipoVitima;
	}
	
	public CrimeVitima() {}

  	public TipoCrime getTipoCrime() {
		return tipoCrime;
	}

	public void setTipoCrime(TipoCrime tipoCrime) {
		this.tipoCrime = tipoCrime;
	}

	public TipoVitima getTipoVitima() {
		return tipoVitima;
	}

	public void setTipoVitima(TipoVitima tipoVitima) {
		this.tipoVitima = tipoVitima;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof CrimeVitima)) {
			return false;
		} else {
			CrimeVitima crimeVitima = (CrimeVitima) obj;
			return crimeVitima.getTipoCrime().equals( this.getTipoCrime() ) && crimeVitima.getTipoVitima().equals( this.getTipoVitima() ) ;
		}

	}
	
	public int hashCode()
	{
		int hash = 7;
		hash = 31 * hash + (null == tipoCrime ? 0 : tipoCrime.hashCode());
		hash = 31 * hash + (null == tipoVitima ? 0 : tipoVitima.hashCode());
		return hash;
	}
	
}
