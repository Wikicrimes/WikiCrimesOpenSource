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

import org.wikicrimes.dao.ConfirmacaoDao;
import org.wikicrimes.model.Confirmacao;
import org.wikicrimes.model.Crime;
import org.wikicrimes.model.Relato;
import org.wikicrimes.model.TipoConfirmacao;

/**
 * 
 */
public class ConfirmacaoDaoHibernate extends GenericCrudDaoHibernate implements
		ConfirmacaoDao {

	public ConfirmacaoDaoHibernate() {
		setEntity(Confirmacao.class);
	}
	public boolean getConfirmacaoExistente(Confirmacao confirmacao){
		String query = "from Confirmacao where " +
				"cri_idcrime = " +confirmacao.getCrime().getIdCrime() + " and usu_idusuario=" + confirmacao.getUsuario().getIdUsuario();
		List list = getHibernateTemplate().find(query);
		if (list.size()>0)
			return true;
		else
			return false;
	}
	@Override
	public List<TipoConfirmacao> getTipoConfirmacoes(boolean positivas) {
		String query = "from TipoConfirmacao where positiva = " + positivas;
		return (List<TipoConfirmacao>) getHibernateTemplate().find(query);
	}
	@Override
	public TipoConfirmacao getTipoConfirmacao(Long id) {
		String query = "from TipoConfirmacao where idTipoConfirmacao = " + id;
		 List result= getHibernateTemplate().find(query);
		 if (result!=null)
			 return (TipoConfirmacao) result.get(0);
		 else
			 return null;
	}
	
	public Boolean verificaSeJaIndicou(Crime c, String email){
		String query = "from Confirmacao conf "+
		"where conf.usuario.email like '"+email+"' and conf.crime.idCrime ="+c.getIdCrime();
		
		List<Confirmacao> result= getHibernateTemplate().find(query);
		if(result.size()>0)
			return true;
		else
			return false;
	}
	@Override
	public Boolean verificaSeJaIndicou(Relato r, String email) {
		String query = "from ConfirmacaoRelato conf "+
		"where conf.usuario.email like '"+email+"' and conf.relato.idRelato ="+r.getIdRelato();
		
		List result= getHibernateTemplate().find(query);
		if(result.size()>0)
			return true;
		else
			return false;
	}

	
}
