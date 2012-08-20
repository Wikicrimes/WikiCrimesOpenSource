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
package org.wikicrimes.util.kernelmap;

import java.awt.Point;
import java.awt.Rectangle;

import org.wikicrimes.model.PontoLatLng;

/**
 * Representa um "bounds" em lat-long vindo do GoogleMaps.
 * Precisa disso pq Rectangle soh aceita inteiros.
 */
public class LatLngBoundsGM {

	public double norte;
	public double sul;
	public double leste;
	public double oeste;
	
	//isso n�o � redundante!
	//Considere quando a emenda do mapa estiver vis�vel, ent�o o valor de oeste pode ser maior que leste. Neste caso, (leste-oeste) daria um valor negativo, diferente da largura
	//Considere ainda se, num n�vel de zoom baixo, estiverem vis�veis v�rias emendas (v�rios mapas do mundo inteiro pequenos)
	public double width;
	public double height;
	
	
	public LatLngBoundsGM(double norte, double sul, double leste, double oeste, double width, double height) {
		this.norte = norte;
		this.sul = sul;
		this.leste = leste;
		this.oeste = oeste;
		this.width = width;
		this.height = height;
	}
	
	public LatLngBoundsGM(PontoLatLng superiorEsquerdo, PontoLatLng inferiorDireito, double width, double height){
		this(superiorEsquerdo.getLatitude(), inferiorDireito.getLatitude(), 
				inferiorDireito.getLongitude(), superiorEsquerdo.getLongitude(), width, height);
	}
	
	public LatLngBoundsGM(double norte, double sul, double leste, double oeste) {
		this.norte = norte;
		this.sul = sul;
		this.leste = leste;
		this.oeste = oeste;
		this.width = norte-sul;
		this.height = leste-oeste;
	}
	
	public LatLngBoundsGM(PontoLatLng superiorEsquerdo, PontoLatLng inferiorDireito){
		this(superiorEsquerdo.getLatitude(), inferiorDireito.getLatitude(), 
				inferiorDireito.getLongitude(), superiorEsquerdo.getLongitude());
	}
	
	public LatLngBoundsGM(PontoLatLng center, int widthPixel, int heightPixel, int zoom) {
		Point centerPixel = center.toPixel(zoom);
		int dx = widthPixel/2;
		int dy = heightPixel/2;
		Point noPixel = new Point(centerPixel.x - dx, centerPixel.y - dy);
		Point sePixel = new Point(centerPixel.x + dx, centerPixel.y + dy);
		PontoLatLng noLatLng = PontoLatLng.fromPixel(noPixel, zoom);
		PontoLatLng seLatLng = PontoLatLng.fromPixel(sePixel, zoom);
		this.norte = noLatLng.lat;
		this.sul = seLatLng.lat;
		this.leste = seLatLng.lng;
		this.oeste = noLatLng.lng;
		this.width = norte-sul;
		this.height = leste-oeste;
	}
	
	public Rectangle toPixel(int zoom) {
		int north = new PontoLatLng(norte, 0.0).toPixel(zoom).y;
		int south = new PontoLatLng(sul, 0.0).toPixel(zoom).y;
		int east = new PontoLatLng(0.0,leste).toPixel(zoom).x;
		int west = new PontoLatLng(0.0,oeste).toPixel(zoom).x;
		int maxX = new PontoLatLng(0,180).toPixel(zoom).x; //x correspondente a 180 graus de longitude
		if(west > east) west = west-maxX;
		int width = east - west;
		int height = south - north;
		return new Rectangle(west, north, width, height);
	}
	
	@Override
	public String toString() {
		return "n:"+ norte +", s:"+ sul +", l:"+ leste +", o:"+ oeste +", w:"+ width +", h:"+ height;
	}
	
}
