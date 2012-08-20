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
package org.wikicrimes.dao;

import java.util.List;

import org.wikicrimes.model.Comentario;
import org.wikicrimes.model.ComentarioRelato;
import org.wikicrimes.model.Confirmacao;
import org.wikicrimes.model.ConfirmacaoRelato;
import org.wikicrimes.model.Crime;
import org.wikicrimes.model.Relato;
import org.wikicrimes.model.RepasseRelato;
import org.wikicrimes.model.Usuario;
import org.wikicrimes.model.UsuarioRedeSocial;

public interface OpensocialDao extends GenericCrudDao {
	
	public Boolean idCadastrado(UsuarioRedeSocial usuario);
	
	public List<Crime> getCrimes(List<Usuario> usuarios);
	
	public List<RepasseRelato> getRepasses(List<UsuarioRedeSocial> usuarios);
	
	public Usuario getUsuario(UsuarioRedeSocial urs);	
	
	public List<org.wikicrimes.model.RepasseRelato> getRelatos(Long idRedeSocial,UsuarioRedeSocial urs);
	
	public List<ComentarioRelato> getComentarios(Relato relato);
	
	public List<Comentario> getComentarios(Crime crime);
	
	public List<UsuarioRedeSocial> getUsuarioRedeSocial(UsuarioRedeSocial urs);
	
	public boolean verificaConfirmacao(ConfirmacaoRelato cr);
	
	public boolean verificaConfirmacao(Confirmacao c);
	
	public boolean verificaSeRepasseFoiRegistrado(RepasseRelato rp);
	
}
