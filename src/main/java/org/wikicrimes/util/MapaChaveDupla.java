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
package org.wikicrimes.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class MapaChaveDupla<K1, K2, V> implements Serializable {
	
	Map<K1, Map<K2, V>> mapao;
	
	public MapaChaveDupla(){
		mapao = new HashMap<K1, Map<K2, V>>();
	}
	
	public void put(K1 chave1, K2 chave2, V valor){
		Map<K2, V> mapinha = mapao.get(chave1);
		if(mapinha == null){
			mapinha = new HashMap<K2, V>();
			mapao.put(chave1, mapinha);
		}
		mapinha.put(chave2, valor);
	}

	public V get(K1 chave1, K2 chave2){
		Map<K2, V> mapinha = mapao.get(chave1);
		if(mapinha == null)
			return null;
		else
			return mapinha.get(chave2);
	}
	
}
