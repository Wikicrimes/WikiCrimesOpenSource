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

public class RepasseRelato extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6848135825731181218L;

	private Long idRepasseRelato;
	
	private UsuarioRedeSocial usuarioEnvio;
	
	private UsuarioRedeSocial usuarioRecebimento;
	
	private Relato relato;
	
	private Crime crime;
	
	private Date dataHoraRegistro;

	public Long getIdRepasseRelato() {
		return idRepasseRelato;
	}

	public void setIdRepasseRelato(Long idRepasseRelato) {
		this.idRepasseRelato = idRepasseRelato;
	}	

	public Relato getRelato() {
		return relato;
	}

	public void setRelato(Relato relato) {
		this.relato = relato;
	}

	public Date getDataHoraRegistro() {
		return dataHoraRegistro;
	}

	public void setDataHoraRegistro(Date dataHoraRegistro) {
		this.dataHoraRegistro = dataHoraRegistro;
	}

	public UsuarioRedeSocial getUsuarioEnvio() {
		return usuarioEnvio;
	}

	public void setUsuarioEnvio(UsuarioRedeSocial usuarioEnvio) {
		this.usuarioEnvio = usuarioEnvio;
	}

	public UsuarioRedeSocial getUsuarioRecebimento() {
		return usuarioRecebimento;
	}

	public void setUsuarioRecebimento(UsuarioRedeSocial usuarioRecebimento) {
		this.usuarioRecebimento = usuarioRecebimento;
	}

	public Crime getCrime() {
		return crime;
	}

	public void setCrime(Crime crime) {
		this.crime = crime;
	}
	
	
}