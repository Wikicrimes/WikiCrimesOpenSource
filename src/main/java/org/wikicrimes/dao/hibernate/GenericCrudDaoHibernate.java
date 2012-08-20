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
package org.wikicrimes.dao.hibernate;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wikicrimes.dao.GenericCrudDao;
import org.wikicrimes.model.BaseObject;

public abstract class GenericCrudDaoHibernate extends HibernateDaoSupport implements
		GenericCrudDao {

	private Class entity = BaseObject.class;

	public boolean save(BaseObject bo) {
		try {
			
			getHibernateTemplate().saveOrUpdate(bo);

			if (logger.isDebugEnabled()) {
				logger.debug("BO set to: " + bo);
			}
			
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean delete(BaseObject to) {
		try {
			getHibernateTemplate().delete(to);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

		return true;
	}

	public BaseObject get(Long id) {
		BaseObject bo = (BaseObject) getHibernateTemplate().get(entity, id);
		if (bo == null) {
			throw new ObjectRetrievalFailureException(entity, id);
		}
		return bo;
	}

	public List<BaseObject> getAll() {
		String nameEntity = entity.getName();
		return getHibernateTemplate().find("from " + nameEntity);
	}
	
	public List<BaseObject> find(BaseObject bo) {
		return getHibernateTemplate().findByExample(bo);
	}

	public boolean exist(BaseObject bo) {
		List list = getHibernateTemplate().findByExample(bo);
		
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Class getEntity() {
		return entity;
	}

	public void setEntity(Class entity) {
		this.entity = entity;
	}

}
