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
package org.wikicrimes.web;

import java.util.List;

import org.wikicrimes.model.Delegacia;
import org.wikicrimes.service.DelegaciaService;

public class DelegaciaForm {
	
	private DelegaciaService delegaciaService;
	private String idDelegacia;
	private String chave;
	private Delegacia delegacia;
	private List<Delegacia> delegaciaList;
	private double latitude;
	private double longitude;
	private String descricao;
	private String endereco;
	private String telefone;
	
	public DelegaciaForm(){
		this.delegacia = new Delegacia();
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public DelegaciaService getDelegaciaService() {
		return delegaciaService;
	}

	public void setDelegaciaService(DelegaciaService delegaciaService) {
		this.delegaciaService = delegaciaService;
	}

	public String getIdDelegacia() {
		return this.idDelegacia;
	}
	
	public void setIdDelegacia(String idDelegacia) {
		this.idDelegacia = idDelegacia;
	}

	public Delegacia getDelegacia() {
		this.delegacia = (Delegacia)delegaciaService.getDelegaciaPorChave(chave);
		return delegacia;
	}

	public void setDelegacia(Delegacia delegacia) {
		this.delegacia = delegacia;
	}

	public List<Delegacia> getDelegaciaList() {
		return delegaciaList;
	}

	public void setDelegaciaList(List<Delegacia> delegaciaList) {
		this.delegaciaList = delegaciaList;
	}
	
}
