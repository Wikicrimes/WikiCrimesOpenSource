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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.wikicrimes.dao.OpensocialDao;
import org.wikicrimes.model.Comentario;
import org.wikicrimes.model.ComentarioRelato;
import org.wikicrimes.model.Confirmacao;
import org.wikicrimes.model.ConfirmacaoRelato;
import org.wikicrimes.model.Crime;
import org.wikicrimes.model.Relato;
import org.wikicrimes.model.RepasseRelato;
import org.wikicrimes.model.Usuario;
import org.wikicrimes.model.UsuarioRedeSocial;



public class OpensocialDaoHibernate extends GenericCrudDaoHibernate implements OpensocialDao {

	public List<Crime> getCrimes(List<Usuario> usuarios) {
		String query = "from Crime c left join fetch c.usuario order by c.dataHoraRegistro desc";
		getHibernateTemplate().setMaxResults(500);
		
		return getHibernateTemplate().find(query);
		
	}
	
	public List<RepasseRelato> getRepasses(List<UsuarioRedeSocial> usuarios){
		if(usuarios.size()==0)
			return null;
		String query = "from RepasseRelato rr where";
		int cont = 0;
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			UsuarioRedeSocial usuarioRedeSocial = (UsuarioRedeSocial) iterator
					.next();
			if(cont==0)	
				query += " rr.usuarioEnvio.idUsuarioDentroRedeSocial like '"+usuarioRedeSocial.getIdUsuarioDentroRedeSocial()+"'";
			else
				query += " or rr.usuarioEnvio.idUsuarioDentroRedeSocial like '"+usuarioRedeSocial.getIdUsuarioDentroRedeSocial()+"'";
			cont++;
			
		}
		query += "order by rr.idRepasseRelato desc";
		
		return getHibernateTemplate().find(query);
	}
	
	
	public List<RepasseRelato> getRelatos(Long idRedeSocial, UsuarioRedeSocial urs) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.set(Calendar.DAY_OF_MONTH, gc.get(Calendar.DAY_OF_MONTH)-Integer.MAX_VALUE);
		java.sql.Date time = new java.sql.Date(gc.getTimeInMillis());
		String query = "from RepasseRelato rp where rp.dataHoraRegistro > '"+time+"' and rp.usuarioEnvio.redeSocial.idRedeSocial = "+idRedeSocial+" and rp.usuarioRecebimento.idUsuarioRedeSocial ="+urs.getIdUsuarioRedeSocial()+" order by rp.dataHoraRegistro desc";
		
		//getHibernateTemplate().setMaxResults(500);
		
		return getHibernateTemplate().find(query);
		
	}
	
	public Usuario getUsuario(UsuarioRedeSocial urs) {
		String query = "select urs.usuario from UsuarioRedeSocial urs where urs.idUsuarioDentroRedeSocial = '"+urs.getIdUsuarioRedeSocial()+"'";
		getHibernateTemplate().setMaxResults(10);		
		List<Usuario> users= getHibernateTemplate().find(query);		
		if (users.size()>0)
			return (Usuario)users.get(0);
		else
			return null;
		
	}
	

	public Boolean idCadastrado(UsuarioRedeSocial urs) {
		// TODO Auto-generated method stub
		String query = "from UsuarioRedeSocial urs" +
				" where urs.idUsuarioDentroRedeSocial='"+urs.getIdUsuarioRedeSocial()+"' " +
				"and urs.redeSocial.dominioRedeSocial like '"+urs.getRedeSocial().getDominioRedeSocial()+"'";		
		List<Usuario> lista = getHibernateTemplate().find(query);
		if(lista.size()==0)
			return false;
		else
			return true;	
	}
	public List<UsuarioRedeSocial> getUsuarioRedeSocial(UsuarioRedeSocial urs) {
		// TODO Auto-generated method stub
		String query = "from UsuarioRedeSocial urs" +
				" where urs.idUsuarioDentroRedeSocial='"+urs.getIdUsuarioRedeSocial()+"' " +
				"and urs.redeSocial.dominioRedeSocial like '"+urs.getRedeSocial().getDominioRedeSocial()+"'";		
		List<UsuarioRedeSocial> lista = getHibernateTemplate().findByExample(urs);
		if(lista.size()==0)
			return null;
		else
			return lista;	
	}
	public List<ComentarioRelato> getComentarios(Relato relato){
		String query = "from ComentarioRelato cr where cr.relato.chave like '" +relato.getChave()+"' order by cr.dataComentario desc";
		
		//getHibernateTemplate().setMaxResults(500);
		
		return getHibernateTemplate().find(query);
	}
	
	public List<Comentario> getComentarios(Crime crime){
		String query = "from Comentario c where c.crime.chave like '" +crime.getChave()+"' order by c.dataConfirmacao desc";
		
		//getHibernateTemplate().setMaxResults(500);
		
		return getHibernateTemplate().find(query);
	}
	
	public boolean verificaConfirmacao(ConfirmacaoRelato cr){
		String query = "from ConfirmacaoRelato cr"
				+ " where cr.relato.idRelato='"
				+ cr.getRelato().getIdRelato() + "' "
				+ "and cr.usuarioRedeSocial.idUsuarioRedeSocial = "
				+ cr.getUsuarioRedeSocial().getIdUsuarioRedeSocial() + "";
		List<Usuario> lista = getHibernateTemplate().find(query);
		if (lista.size() == 0)
			return false;
		else
			return true;
	}
	
	public boolean verificaSeRepasseFoiRegistrado(RepasseRelato rp){
		String query = "";
		if(rp.getRelato()!=null){	
			query = "from RepasseRelato rp"
				+ " where rp.relato.idRelato='" + rp.getRelato().getIdRelato() + "'"				
				+ " and rp.usuarioRecebimento.idUsuarioRedeSocial = "+ rp.getUsuarioRecebimento().getIdUsuarioRedeSocial() ;
		}
		if(rp.getCrime()!=null){	
			query = "from RepasseRelato rp"
				+ " where rp.crime.idCrime='" + rp.getCrime().getIdCrime() + "'"				
				+ " and rp.usuarioRecebimento.idUsuarioRedeSocial = "+ rp.getUsuarioRecebimento().getIdUsuarioRedeSocial() ;
		}
			List<Usuario> lista = getHibernateTemplate().find(query);
		if (lista.size() == 0)
			return false;
		else
			return true;
	}


	@Override
	public boolean verificaConfirmacao(Confirmacao c) {
		String query = "from Confirmacao c"
			+ " where c.crime.idCrime='"
			+ c.getCrime().getIdCrime() + "' "
			+ "and c.usuarioRedeSocial.idUsuarioRedeSocial = "
			+ c.getUsuarioRedeSocial().getIdUsuarioRedeSocial() + "";
		List<Usuario> lista = getHibernateTemplate().find(query);
		if (lista.size() == 0)
			return false;
		else
			return true;
		}
}
