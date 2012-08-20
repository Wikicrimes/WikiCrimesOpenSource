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
import java.util.Map;

public class ImagemMapa  extends BaseObject{

	private static final long serialVersionUID = 1L;

	private Long idImagemMapa;
	private String token;//string criptografada pra esconder o id
	
	//centro, zoom , size
	private PontoLatLng centro;
	private Integer zoom;
	private Integer width;
	private Integer height;
	private Integer viewedQrCode;
	
	//poligono
	private List<PontoLatLng> poligono;
	
	//bounds
	private Double north;
	private Double south;
	private Double east;
	private Double west;
	
	//filtro
	private Map<String, String> filtro;
	
	//usuario, data
	private Usuario usuario;
	private Date dataHoraRegistro;
	
	public List<PontoLatLng> setPoligonoAndReturn(String vertices){
		List<PontoLatLng> listaPontos = new ArrayList<PontoLatLng>();
		String[] pts = vertices.split("\\|");
		for(String ptStr : pts){
			PontoLatLng pt = new PontoLatLng(ptStr);
			listaPontos.add(pt);
		}
		setPoligono(listaPontos);
		return listaPontos;
	}
	
	public PontoLatLng getCentro() {
		return centro;
	}
	public void setCentro(PontoLatLng centro) {
		this.centro = centro;
	}
	public Integer getZoom() {
		return zoom;
	}
	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
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
	public Long getIdImagemMapa() {
		return idImagemMapa;
	}
	public void setIdImagemMapa(Long idImagemMapa) {
		this.idImagemMapa = idImagemMapa;
	}
	public List<PontoLatLng> getPoligono() {
		return poligono;
	}
	public void setPoligono(List<PontoLatLng> poligono) {
		this.poligono = poligono;
	}
	public Double getNorth() {
		return north;
	}
	public void setNorth(Double north) {
		this.north = north;
	}
	public Double getSouth() {
		return south;
	}
	public void setSouth(Double south) {
		this.south = south;
	}
	public Double getEast() {
		return east;
	}
	public void setEast(Double east) {
		this.east = east;
	}
	public Double getWest() {
		return west;
	}
	public void setWest(Double west) {
		this.west = west;
	}
	public Map<String, String> getFiltro() {
		return filtro;
	}
	public void setFiltro(Map<String, String> filtro) {
		this.filtro = filtro;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getViewedQrCode() {
		if(viewedQrCode == null)
			return 0;
		return viewedQrCode;
	}
	public void setViewedQrCode(Integer viewedQrCode) {
		this.viewedQrCode = viewedQrCode;
	}
}
