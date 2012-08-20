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
package org.wikicrimes.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.wikicrimes.util.GoogleMapsData;

public class GoogleEnderecoService {
	public GoogleMapsData consultaRuaURL(String url) throws IOException, XMLStreamException, FactoryConfigurationError{
		url = url.replace(' ', '+');
		
		URL googleService = new URL("http://maps.google.com/maps/geo?q=" + url + "&output=xml&key=ABQIAAAAFMKMB22peYEk-DnRBRjxZhRk8R8qbs4FIOFRgqzDQO3UVKhx7BTRb8DofYsZ7bJrhTwSbePuBeOFBQ");
		
        URLConnection googleConnection = googleService.openConnection();
        GoogleMapsData coor = processaDadoRequisicao(googleConnection.getInputStream());
		return coor;
	}
	
	public GoogleMapsData consultaRuaCoordenadas(String coordenadas) throws IOException, XMLStreamException, FactoryConfigurationError{
		URL googleService = new URL("http://maps.google.com/maps/geo?q=" + coordenadas + "&output=xml&key=ABQIAAAAFMKMB22peYEk-DnRBRjxZhRk8R8qbs4FIOFRgqzDQO3UVKhx7BTRb8DofYsZ7bJrhTwSbePuBeOFBQ");
		
        URLConnection googleConnection = googleService.openConnection();
        
        GoogleMapsData coor = processaDadoRequisicaoEndereco(googleConnection.getInputStream()); 
        return coor;
	}
	
	private GoogleMapsData processaDadoRequisicaoEndereco(InputStream isr) throws XMLStreamException, FactoryConfigurationError{
		GoogleMapsData gDados = new GoogleMapsData();
		
		XMLEventReader leitor = XMLInputFactory.newInstance().createXMLEventReader(isr);
		while(leitor.hasNext()){
			XMLEvent evento = leitor.nextEvent();
			
			if(evento.isStartElement()){
				if(evento.asStartElement().getName().getLocalPart().equalsIgnoreCase("ThoroughfareName")){
					evento = leitor.nextEvent();
					String str = evento.asCharacters().getData();
					
					gDados.setEndereco(str);
					break;
				}
			}
		}
		return gDados;
	}
	
	private GoogleMapsData processaDadoRequisicao(InputStream isr) throws XMLStreamException, FactoryConfigurationError{
		GoogleMapsData gDados = new GoogleMapsData();
			
		XMLEventReader leitor = XMLInputFactory.newInstance().createXMLEventReader(isr);
		while(leitor.hasNext()){
			XMLEvent evento = leitor.nextEvent();
			
			if(evento.isStartElement()){
				if(evento.asStartElement().getName().getLocalPart().equalsIgnoreCase("ThoroughfareName")){
					evento = leitor.nextEvent();
					String str = evento.asCharacters().getData();
					gDados.setEndereco(str);
					continue;//volta pro while
				}
				if(evento.asStartElement().getName().getLocalPart().equalsIgnoreCase("coordinates")){
					evento = leitor.nextEvent();
					String str = evento.asCharacters().getData();
					
					String vetor[] = str.split(",");
					
					gDados.setLongitude(Double.parseDouble(vetor[0]));
					gDados.setLatitude(Double.parseDouble(vetor[1]));
					break;
				}
			}
		}
		return gDados;
	}
}
