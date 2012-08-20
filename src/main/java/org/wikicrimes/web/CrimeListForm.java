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

import java.util.ArrayList;
import java.util.List;

import org.wikicrimes.model.Usuario;
import org.wikicrimes.service.CrimeService;

public class CrimeListForm extends GenericForm {
    private CrimeService crimeService;
    private String sortColumn = "data";
    private boolean ascending = true;
    private List crimes = new ArrayList();
    
    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    public void setCrimeService(CrimeService crimeService) {
        this.crimeService = crimeService;
    }
    
    public List getCrimes() {
        //List crimes = crimeService.getAll();// userManager.getUsers();
    	Usuario usuario = (Usuario) this.getSessionScope().get("usuario");
        
    	
        if(usuario !=null) {
        	crimes = crimeService.getByUser(usuario.getIdUsuario());
        } 
        
        
        
        return crimes;
    }
}

