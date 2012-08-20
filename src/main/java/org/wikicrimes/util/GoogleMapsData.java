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

import java.util.HashMap;
import java.util.Map;

public class GoogleMapsData {
	private double latitude,longitude;
	private String endereco;

	private String acentuado = "���������������������������������������������������";
    private String semAcento = "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOU";
    
    private int tamanhoVetor=256;
    private Map<Character, Character> tabelaMudanca;
	
	public GoogleMapsData() {
		this(0, 0);
	}
	
	public GoogleMapsData(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		tabelaMudanca = new HashMap<Character, Character>();
		
		inicializaTabela();
	}
	
	private void inicializaTabela(){
        for (int i = 0; i < tamanhoVetor; ++i) {
            tabelaMudanca.put((char) i, (char) i);
        }
        for (int i = 0; i < acentuado.length(); ++i) {
        	Character ch = tabelaMudanca.remove((char)acentuado.charAt(i));
        	tabelaMudanca.put(ch, (char)semAcento.charAt(i));
        }
        semAcento=acentuado=null;
        System.gc();
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = removeAcentos(endereco);
	}
	
	private String removeAcentos(final String s){
         StringBuffer sb = new StringBuffer();
         for (int i = 0; i < s.length(); ++i) {
             char ch = s.charAt (i);
             if (ch < tamanhoVetor) {
                 sb.append (tabelaMudanca.get(ch));
             } else {
                 sb.append (ch);
             }
         }
         return sb.toString();
    }
}
