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

public class Report {

	Parser parser;
	int successCount, discardCount, repeatCount, totalCount;
	
	public Report(Parser parser) {
		this.parser = parser;
	}

	public void countSuccess(Model crime){
		successCount++;
		totalCount++;
		System.out.print(totalCount + " ");
		System.out.println("Crime importado, id_original=" + crime.CRI_ID_ORIGINAL);
	}
	
	public void countException(IgnoredCrimeException exception){
		switch(exception.reason){
		case PREVIOUSLY_IMPORTED:
			repeatCount++;
			break;
		case DISCARDED_TYPE:
			discardCount++;
			writeToFile(exception.details);
			break;
		case UNKNOWN_TYPE:
			discardCount++;
			writeToFile(exception.details);
			break;
		case INSUFICIENT_DATA:
			discardCount++;
			writeToFile(exception.rawData);
			break;
		}
		totalCount++;
		System.out.print(totalCount + " ");
		System.out.println("Crime ignorado, razao=" + exception.reason);
	}
	
	public void printSummary(){
		System.out.printf("%s: %d crimes importados, %d descartados, %d repetidos\n", parser.getBaseName(), successCount, discardCount, repeatCount);
	}
	
	private void writeToFile(String str){
		//TODO listar os tipos desconhecidos, pra pessoa incluir no parser 
		//TODO listar razoes dos outros descartes tb, pra pessoa checar se tah descartando certo
	}
	
}
