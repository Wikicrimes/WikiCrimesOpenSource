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
package org.wikicrimes.util.statistics;

import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.wikicrimes.model.PontoLatLng;
import org.wikicrimes.util.statistics.Param.Application;

import br.com.wikinova.heatmaps.KernelMap;

public class SessionBuffer {

	private StatReqResults res;
	private final String SESSION_KEY = "STATISTICS";
	
	
	@SuppressWarnings("unchecked")
	public SessionBuffer(HttpSession session, Application app) {
		Map<Application, StatReqResults> map = (Map<Application, StatReqResults>)session.getAttribute(SESSION_KEY);
		if(map == null) {
			map = new HashMap<Application, StatReqResults>();
			session.setAttribute(SESSION_KEY, map);
		}
		res = map.get(app);
		if(res == null) {
			res = new StatReqResults();
			map.put(app, res);
		}
	}
	
	public SessionBuffer(HttpServletRequest request) {
		this(request.getSession(),Param.getApplication(request));
	}
	
	public void saveKernelMap(KernelMap obj, Image img, String booleanGrid) {
		res.kernelmapObj = obj;
		res.kernelmapImg = img;
		res.kernelmapBooleanGrid = booleanGrid;
	}
	
	public void saveChartsUrls(String typeChartUrl, String reasonChartUrl) {
		res.typesChartUrl = typeChartUrl;
		res.reasonsChartUrl = reasonChartUrl;
	}
	
	public void saveTotalEvents(int totalEvents) {
		res.totalEvents = totalEvents;
	}
	
	public void saveStartDate(Date startDate){
		res.startDate = startDate;
	}
	
	public void saveEvents(String events) {
		res.events = events;
	}
	
	public void saveCenter(PontoLatLng center) {
		res.center = center;
	}
	
	public KernelMap getKernelMap() {
		return res.kernelmapObj;
	}
	
	public Image getKernelMapImage() {
		return res.kernelmapImg;
	}
	
	public String getKernelMapBooleanGrid() {
		return res.kernelmapBooleanGrid;
	}
	
	public String getTypesChartUrl() {
		return res.typesChartUrl;
	}
	
	public String getReasonsChartUrl() {
		return res.reasonsChartUrl;
	}
	
	public int getTotalEvents() {
		return res.totalEvents;
	}
	
	public String getStartDate(){
		if(res.startDate == null)
			return null;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(res.startDate);
	}
	
	public String getEvents() {
		return res.events;
	}
	
	public PontoLatLng getCenter() {
		return res.center;
	}
	
	public void clear() {
		res.totalEvents = 0;
		res.startDate = null;
		res.events = null;
		res.center = null;
		res.kernelmapImg = null;
		res.kernelmapObj = null;
		res.kernelmapBooleanGrid = null;
		res.typesChartUrl = null;
		res.reasonsChartUrl = null;
	}
}

class StatReqResults{
	int totalEvents;
	Image kernelmapImg;
	KernelMap kernelmapObj;
	String typesChartUrl, reasonsChartUrl, events, kernelmapBooleanGrid;
	Date startDate;
	PontoLatLng center;
	
}
