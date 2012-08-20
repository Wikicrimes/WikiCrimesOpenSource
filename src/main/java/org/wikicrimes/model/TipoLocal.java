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

public class TipoLocal extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4019952798222943365L;

	private Long idTipoLocal;
	private String nome;
	private String descricao;
	private TipoVitima tipoVitima;

	public TipoVitima getTipoVitima() {
		return tipoVitima;
	}

	public void setTipoVitima(TipoVitima tipoVitima) {
		this.tipoVitima = tipoVitima;
	}

	public TipoLocal() {}
	
	public TipoLocal(Long id) {
		idTipoLocal = id;
	}

	public Long getIdTipoLocal() {
		return idTipoLocal;
	}

	public void setIdTipoLocal(Long idTipoLocal) {
		this.idTipoLocal = idTipoLocal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

  	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof TipoLocal)) {
			return false;
		} else {
			TipoLocal tipoLocal = (TipoLocal) obj;
			return tipoLocal.getIdTipoLocal().equals( this.getIdTipoLocal() );
		}

	}
	
}
