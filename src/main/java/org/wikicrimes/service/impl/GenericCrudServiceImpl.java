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

import org.wikicrimes.dao.GenericCrudDao;
import org.wikicrimes.model.BaseObject;
import org.wikicrimes.service.GenericCrudService;

public abstract class GenericCrudServiceImpl implements GenericCrudService {

	private GenericCrudDao dao;
	
	public BaseObject get(Long id) {
		return dao.get(id);
	}
	
	public List<BaseObject> getAll() {
		return dao.getAll();
	}

	public boolean insert(BaseObject bo) {
		return dao.save(bo);
	}

	public boolean update(BaseObject bo) {
		return dao.save(bo);
	}
	
	public boolean delete(BaseObject bo) {
		return dao.delete(bo);
	}

	public GenericCrudDao getDao() {
		return dao;
	}

	public void setDao(GenericCrudDao dao) {
		this.dao = dao;
	}

	public boolean exist(BaseObject bo) {
		return getDao().exist(bo);
	}
	

	public List<BaseObject> find(BaseObject bo) {
	    return dao.find(bo);
	}
	
}
