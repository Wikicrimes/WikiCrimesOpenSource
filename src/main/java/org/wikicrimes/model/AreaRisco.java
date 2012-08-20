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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AreaRisco extends BaseObject{
	
	private static final long serialVersionUID = 1L;

	private Long idAreaRisco;
	
	private String nome;
	private List<PontoLatLng> vertices;
	
	private Usuario usuario;
	private Date dataHoraRegistro;
	
	
	public List<PontoLatLng> setVerticesAndReturn(String vertices){
		List<PontoLatLng> listaPontos = new ArrayList<PontoLatLng>();
		String[] pts = vertices.split("\\|");
		for(String ptStr : pts){
			PontoLatLng pt = new PontoLatLng(ptStr);
			listaPontos.add(pt);
		}
		setVertices(listaPontos);
		return listaPontos;
	}
	public List<PontoLatLng> getVertices() {
		return vertices;
	}
	public void setVertices(List<PontoLatLng> vertices) {
		this.vertices = vertices;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDataHoraRegistro() {
		return dataHoraRegistro;
	}
	public void setDataHoraRegistro(Date datahoraRegistro) {
		this.dataHoraRegistro = datahoraRegistro;
	}
	public Long getIdAreaRisco() {
		return idAreaRisco;
	}
	public void setIdAreaRisco(Long idAreaRisco) {
		this.idAreaRisco = idAreaRisco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += idAreaRisco + "|" + nome + "|";
		for(PontoLatLng p : vertices)
			str += p + "|";
		str = str.substring(0, str.length()-1);
		return str;
	}
	
	public static String listToString(List<AreaRisco> list){
		String str = "";
		if(!list.isEmpty()){
			for(AreaRisco a : list)
				str += a + "||";
			str = str = str.substring(0, str.length()-2);
		}
		return str;
	}
}
