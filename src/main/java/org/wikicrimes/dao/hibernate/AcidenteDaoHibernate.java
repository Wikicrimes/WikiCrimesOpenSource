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
import java.util.Map;

import org.wikicrimes.dao.AcidenteDao;
import org.wikicrimes.model.Acidente;

/**
 * 
 */
public class AcidenteDaoHibernate extends GenericCrudDaoHibernate implements
		AcidenteDao {

	public AcidenteDaoHibernate() {
		setEntity(Acidente.class);
	}

	@SuppressWarnings("unchecked")
	public List<Acidente> filter(Map<String, Object> parameters) {
		String consulta = "from Acidente as aci where ";
		
		//crimes no Viewport
		if (parameters.get("norte")!=null && parameters.get("sul")!=null && parameters.get("leste")!=null && parameters.get("oeste")!=null){
			
			if (Double.parseDouble(parameters.get("leste").toString())> Double.parseDouble(parameters.get("oeste").toString())) {
				//retorna todos os crimes dentro da southwest/northeast boundary
				consulta+=" (aci.longitude< " + parameters.get("leste") + " and aci.longitude> " + parameters.get("oeste") + ") and (aci.latitude<= " + parameters.get("norte") + " and aci.latitude>= " + parameters.get("sul") + ")";
			}
			else {
				 //retorna todos os crimes dentro da southwest/northeast boundary
				 //split over the meridian
				consulta+=" (aci.longitude<= " + parameters.get("leste") + " or aci.longitude>= " + parameters.get("oeste") + ") and (aci.latitude<= " + parameters.get("norte") + " and aci.latitude>= " + parameters.get("sul") + ")";
			}		
		}
		
		return (List<Acidente>) getHibernateTemplate().find(consulta);
	}
	
	
}
