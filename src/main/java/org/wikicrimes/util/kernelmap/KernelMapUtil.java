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
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.wikicrimes.model.PontoLatLng;
import org.wikicrimes.util.statistics.AccidentEventsRetriever;
import org.wikicrimes.util.statistics.WikiCrimesEventsRetriever;
import org.wikinova.rotaSegura.ParametroInvalidoRotaSeguraException;

import br.com.wikinova.heatmaps.KernelMap;
import br.com.wikinova.heatmaps.util.Ponto;

public class KernelMapUtil {

	public static KernelMap fazerKernelMap(PontoLatLng centro, double raioKm, int zoom, ServletContext context, String eventType, Date dataInicial) {
		Rectangle boundsPixel = getBoundsPixel(centro, raioKm, zoom); 
		List<Point> events = getEvents(boundsPixel, zoom, context, dataInicial, eventType);
		return new KernelMap(boundsPixel, events);
	}
	
	public static Rectangle getBoundsPixel(PontoLatLng centro, double raioKm, int zoom) {
		PontoLatLng no = centro.transladarKm(-raioKm, -raioKm);
		Ponto noPixel = no.toPixel(zoom);
		PontoLatLng se = centro.transladarKm(raioKm, raioKm);
		Ponto sePixel = se.toPixel(zoom);
		return new Rectangle(noPixel.x, noPixel.y, sePixel.x-noPixel.x, sePixel.y-noPixel.y);
	}
	
	public static Rectangle getBoundsPixel(PontoLatLng centro, int width, int height, int zoom) {
		Point centroPixel = centro.toPixel(zoom);
		Point cantoPixel = new Point(centroPixel.x - width/2, centroPixel.y - height/2);
		return new Rectangle(cantoPixel.x, cantoPixel.y, width, height);
	}
	
	public static List<Point> getEvents(Rectangle boundsPixel, int zoom, ServletContext context, Date dataInicial, String eventType) {
		List<Point> points;
		if(eventType == null || eventType.equals("") || eventType.equalsIgnoreCase("crime")) { //default
			WikiCrimesEventsRetriever er = new WikiCrimesEventsRetriever(boundsPixel, zoom, dataInicial, context);
			points = er.getPoints();
		}else if(eventType.equalsIgnoreCase("acidente")) {
			AccidentEventsRetriever er = new AccidentEventsRetriever(context, boundsPixel, zoom, dataInicial);
			points = er.getPoints();
		}else if(eventType.equalsIgnoreCase("crime|acidente")) {
			WikiCrimesEventsRetriever er1 = new WikiCrimesEventsRetriever(boundsPixel, zoom, dataInicial, context);
			AccidentEventsRetriever er2 = new AccidentEventsRetriever(context, boundsPixel, zoom, dataInicial);
			points = er1.getPoints();
			points.addAll(er2.getPoints());
		}else {
			throw new ParametroInvalidoRotaSeguraException("Parametro eventos invalido. Valores possiveis: crime, acidente e crime|acidente. Valor passado: " + eventType);
		}
		return points;
	}
	
}
