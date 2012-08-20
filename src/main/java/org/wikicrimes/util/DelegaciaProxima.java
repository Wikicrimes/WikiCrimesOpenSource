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
package org.wikicrimes.util;

public class DelegaciaProxima implements Comparable<DelegaciaProxima> {
	private Long idFonteExterna;
	private Double latitude;
	private Double longitude;
	private Double distancia;
	private String nome;
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public DelegaciaProxima(Long idFonteExterna, Double latitude,
			Double longitude, Double distancia, String nome) {
		super();
		this.idFonteExterna = idFonteExterna;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distancia = distancia;
		this.nome = nome;
	}



	public DelegaciaProxima() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdFonteExterna() {
		return idFonteExterna;
	}

	public void setIdFonteExterna(Long long1) {
		this.idFonteExterna = long1;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public int	compareTo(DelegaciaProxima d) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
		
	    if(this.distancia < d.distancia) return BEFORE;
	    
	    if(this.distancia > d.distancia) return AFTER;
	    
	    if(this.distancia == d.distancia) return EQUAL;
	    return EQUAL;
    }


	

}
