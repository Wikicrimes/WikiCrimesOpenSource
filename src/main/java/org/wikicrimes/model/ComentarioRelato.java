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
package org.wikicrimes.model;

import java.util.Date;

public class ComentarioRelato extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1252038181769820706L;

	private Long idComentario;
	private String descComentario;
	private Date dataComentario;
	private Usuario usuario;
	private String link;
	private Relato relato;
	private String embedLink;
	private Long idComentarioPai;
	private UsuarioRedeSocial usuarioRedeSocial; 
	
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof ComentarioRelato)) {
			return false;
		} else {
			ComentarioRelato comentario = (ComentarioRelato) obj;
			return comentario.getIdComentario().equals( this.getIdComentario() );
		}

	}


	public Long getIdComentario() {
		return idComentario;
	}


	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}


	public String getDescComentario() {
		return descComentario;
	}


	public void setDescComentario(String descComentario) {
		this.descComentario = descComentario;
	}


	public Date getDataComentario() {
		return dataComentario;
	}


	public void setDataComentario(Date dataComentario) {
		this.dataComentario = dataComentario;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public Relato getRelato() {
		return relato;
	}


	public void setRelato(Relato relato) {
		this.relato = relato;
	}


	public String getEmbedLink() {
		return embedLink;
	}


	public void setEmbedLink(String embedLink) {
		this.embedLink = embedLink;
	}


	public Long getIdComentarioPai() {
		return idComentarioPai;
	}


	public void setIdComentarioPai(Long idComentarioPai) {
		this.idComentarioPai = idComentarioPai;
	}


	public UsuarioRedeSocial getUsuarioRedeSocial() {
		return usuarioRedeSocial;
	}


	public void setUsuarioRedeSocial(UsuarioRedeSocial usuarioRedeSocial) {
		this.usuarioRedeSocial = usuarioRedeSocial;
	}

}
