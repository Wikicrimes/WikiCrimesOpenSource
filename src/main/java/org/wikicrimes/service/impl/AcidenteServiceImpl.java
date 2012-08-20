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
package org.wikicrimes.service.impl;

import java.util.List;
import java.util.Map;

import org.wikicrimes.dao.AcidenteDao;
import org.wikicrimes.model.Acidente;
import org.wikicrimes.model.BaseObject;
import org.wikicrimes.service.AcidenteService;
import org.wikicrimes.util.Cripto;

public class AcidenteServiceImpl extends GenericCrudServiceImpl implements AcidenteService {
	
	private AcidenteDao acidenteDao;
	
	public List<Acidente> filter(Map<String, Object> parameters) {
		return acidenteDao.filter(parameters);
	}
		
	public boolean insert(Acidente aci) {
		
		if (getDao().save(aci)) {
			aci.setChave(Cripto.criptografar(aci.getIdAcidente().toString()+aci.getDataHoraRegistro().toString()));
			getDao().save(aci);
			return true;
		}
		
		return false;
	}
	
	
	public Acidente get(Long id){
		Acidente temp=(Acidente) this.getDao().get(id);
		return temp;
	}
	
	public Acidente getAcidente(String chave) {
		Acidente aci= new Acidente();
		aci.setChave(chave);
		List<BaseObject> list =this.getDao().find(aci);
		if (list.size() != 0){
			
			return aci;
		}
		else
			return null;
	
	}

	public AcidenteDao getAcidenteDao() {
		return acidenteDao;
	}

	public void setAcidenteDao(AcidenteDao acidenteDao) {
		this.acidenteDao = acidenteDao;
	}
	
}
