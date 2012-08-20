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

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.wikicrimes.util.crimeBaseImport.specific.PocoDeCaldasParser;
//import org.wikicrimes.util.crimeBaseImport.specific.WashingtonParser;

public class Main {

	private static final String DIR = "/home/vladimir/Transferências/";//"/home/carlos/Downloads/";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, ParseException {
		DAO dao = new DAO();
//		dao.importCrimes(new CrimespottingParser(CityOption.OAKLAND, new File(DIR, "crime-data")));
//		dao.importCrimes(new PortlandParser(new File(DIR, "portland.csv.txt")));
//		dao.importCrimes(new AtlantaParser(new File(DIR, "Cobra.txt")));
//		dao.importCrimes(new WashingtonParser(new File(DIR, "crime_incidents_2011_CSV.csv")));
		dao.importCrimes(new PocoDeCaldasParser(new File(DIR,"CV REDS detalhado -  wikcrimes.xls")));
	}
	
}
