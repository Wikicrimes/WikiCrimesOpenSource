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

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.wikicrimes.model.EntidadeCertificadora;
import org.wikicrimes.service.EntidadeCertificadoraService;

public class EntidadeCertificadoraForm extends GenericForm {
	
	
	private String nome;
	private String descricao;
	private String homepage;
	
	private EntidadeCertificadoraService entidadeCertificadoraService;
		

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getHomepage() {
		return homepage;
	}


	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	
	
	public String cadastro (){
		if (expirouSessao()) {
			
			return SESSAO_EXPIRADA;
		}
		if(!isAdmin()){
			return SESSAO_EXPIRADA;
		}
		String returnPage = "failure";
		EntidadeCertificadora entCert = new EntidadeCertificadora();
		entCert.setNome(nome);
		entCert.setDescricao(descricao);
		entCert.setHomepage(homepage);
		if(entidadeCertificadoraService.insert(entCert)){
			FacesMessage message = new FacesMessage();			
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setDetail("Entidade Certificadora registrada com sucesso!");
			FacesContext.getCurrentInstance().addMessage("regEntCerForm", message);
		}
		else{
			FacesMessage message = new FacesMessage();			
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setDetail("Problemas no cadastro!");
			FacesContext.getCurrentInstance().addMessage("regEntCerForm", message);
		}		
		returnPage = null;
		

		return returnPage;
	}


	public EntidadeCertificadoraService getEntidadeCertificadoraService() {
		return entidadeCertificadoraService;
	}


	public void setEntidadeCertificadoraService(
			EntidadeCertificadoraService entidadeCertificadoraService) {
		this.entidadeCertificadoraService = entidadeCertificadoraService;
	}
	
		
}