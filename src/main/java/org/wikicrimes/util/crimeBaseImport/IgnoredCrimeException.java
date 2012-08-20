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
package org.wikicrimes.util.crimeBaseImport;

/**
 * 
 * Pra informar (pro metodo mais externo) q um crime deve ser descartado. Ex: pq eh de um tipo q nao existe na base do Wikicrimes
 * 
 * @author victor
 *
 */
@SuppressWarnings("serial")
public class IgnoredCrimeException extends Exception{

	public static enum Reason {
		PREVIOUSLY_IMPORTED, //ja existe no banco um crime com mesmo id_original e id_base_origem 
		DISCARDED_TYPE, //tipo de crime nao existe no banco, ex: prostituicao, drogas, fraude, incendio culposo, etc
		UNKNOWN_TYPE, //tipo de crime desconhecido, nao incluido no codigo do converter
		INSUFICIENT_DATA; //dados insuficientes, algum campo obritgatorio ficou null
	}
	
	public final Reason reason;
	public String details;
	public String rawData;
	public Parser converter;
	
	public IgnoredCrimeException(Reason reason){
		super("Crime ignorado, razao: " + reason);
		this.reason = reason;
	}
	
	public IgnoredCrimeException(Reason reason, String details){
		super("Crime ignorado, razao: " + reason + " (" + details + ")");
		this.reason = reason;
		this.details = details;
	}
	
	public void setRawData(String str){
		this.rawData = str;
	}
	
	public void setConverter(Parser converter){
		this.converter = converter;
	}
	
}
