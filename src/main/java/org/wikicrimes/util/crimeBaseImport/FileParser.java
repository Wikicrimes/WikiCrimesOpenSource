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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public abstract class FileParser extends Parser{

	BufferedReader br;
	
	public FileParser(File file) throws IOException {
		br = new BufferedReader(new FileReader(file));
		br.readLine(); //skip header
	}
	
	@Override
	public String next() throws IOException {
		return br.readLine();
	}
	
	public static String[] splitFields(String rawData, char separator, char quote){
		List<String> rawFields = new ArrayList<String>();
		int begin = 0;
		boolean insideQuotes = false;
		for(int i=0; i<rawData.length(); i++){
			char c = rawData.charAt(i);
			if(c == separator){
				if(!insideQuotes){
					String field = rawData.substring(begin, i);
					rawFields.add(field);
					begin = i+1;
				}
			}else if(c == quote){
				insideQuotes = !insideQuotes;
			}
		}
		rawFields.add(rawData.substring(begin));
		return rawFields.toArray(new String[rawFields.size()]);
	}

	@Override
	protected abstract String getBaseName();

	@Override
	protected abstract String getBaseUrl();

	@Override
	protected abstract Model specificConvert(String rawData) throws ParseException, IgnoredCrimeException;

}
