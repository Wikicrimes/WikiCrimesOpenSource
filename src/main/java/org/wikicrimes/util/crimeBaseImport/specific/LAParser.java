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
package org.wikicrimes.util.crimeBaseImport.specific;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.wikicrimes.util.crimeBaseImport.IgnoredCrimeException;
import org.wikicrimes.util.crimeBaseImport.Model;
import org.wikicrimes.util.crimeBaseImport.Parser;
import org.wikicrimes.util.crimeBaseImport.Util;

/**
 * http://projects.latimes.com/mapping-la/crime/neighborhood/json/?hood=pico-robertson&start_date=2012-03-16&end_date=2012-04-16&callback=x
 * 
 * @author victor
 *
 * TODO: nao ta pronto ainda
 *
 */
public class LAParser extends Parser{

	
	
	private final Date firstDate = new Date();
	private final Date lastDate = new Date();
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		Date date1 = new Date();
		Date date2 = new Date();
		String url = "http://projects.latimes.com/mapping-la/crime/neighborhood/json/?hood=pico-robertson&start_date=" + date1 + "&end_date=" + date2 + "&callback=x";
		JSONArray arrayJson = Util.requestJson(new URL(url));
		
		for(int i=0; i<arrayJson.size(); i++){
			JSONObject crimeJson = arrayJson.getJSONObject(i);
			String title = crimeJson.getString("title");
			String dateStr = crimeJson.getString("start");
			String slug = crimeJson.getString("theft");
			String descHtml = crimeJson.getString("description");
			int descStart = descHtml.indexOf("<br>") + 5;
			int descEnd = descHtml.indexOf("<br>", descStart);
			String desc = descHtml.substring(descStart, descEnd);
			int idStart = descHtml.indexOf("href='/mapping-la/crime/report/") + 31;
			int idEnd = descHtml.indexOf("/", idStart);
			String id = descHtml.substring(idStart, idEnd);
			JSONObject pointJson = crimeJson.getJSONObject("point");
			double lat = pointJson.getDouble("lat");
			double lng = pointJson.getDouble("lng");
		}
		
	}
	
	protected LAParser() throws ClassNotFoundException, SQLException, IOException {
		super();
	}
	
	@Override
	protected String getBaseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String next() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Model specificConvert(String rawData) throws ParseException, IgnoredCrimeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
