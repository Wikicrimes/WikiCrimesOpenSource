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

import java.io.IOException;

import com.maxmind.geoip.LookupService;

public class GeoData {
    // Uncomment for windows
    //private String dir = System.getProperty("user.dir"); 

    // Uncomment for Linux
    private String dir = "/root/workspace/wikicrimes";
	//private String dir = "/home/victor/Desktop/Documents/Eclipse Workspace/wikicrimes/";
	//private String dir = System.getProperty("user.dir");
	private String sep = System.getProperty("file.separator");
    private  String dbfile = dir + sep + "GeoIP.dat"; 
    private LookupService cl;
    private static GeoData geo;
	    // You should only call LookupService once, especially if you use
	    // GEOIP_MEMORY_CACHE mode, since the LookupService constructor takes up
	    // resources to load the GeoIP.dat file into memory
	    //LookupService cl = new LookupService(dbfile,LookupService.GEOIP_STANDARD);
	private GeoData(){
		
		try {
			cl = new LookupService(dbfile,LookupService.GEOIP_MEMORY_CACHE);
		} catch (IOException e) {
			System.err.println(e.getMessage() + dbfile);
			e.printStackTrace();
		}
	}    
    public static GeoData getInstance(){
        if (geo == null)
        	return new GeoData();
        else
        	return geo;
    }
    public LookupService getLookupService(){
    	return cl;
    }

	    
}
