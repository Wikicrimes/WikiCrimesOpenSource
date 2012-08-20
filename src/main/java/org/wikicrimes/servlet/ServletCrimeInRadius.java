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
package org.wikicrimes.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.wikicrimes.model.MobileRequestLog;
import org.wikicrimes.model.PontoLatLng;
import org.wikicrimes.service.CrimeService;
import org.wikicrimes.service.LogService;
import org.wikicrimes.util.kernelmap.AvaliacaoPerigo;

public class ServletCrimeInRadius extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CrimeService service;
	private LogService logService;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		long initDateMilliSeconds = Long.parseLong(request.getParameter("initDate"));
		long finalDateMilliSeconds = Long.parseLong(request.getParameter("finalDate"));
		double credibilidadeMin = Double.parseDouble(request.getParameter("credMin")==null?"0.0":request.getParameter("credMin"));
		double credibilidadeMax = Double.parseDouble(request.getParameter("credMax")==null?"1.0":request.getParameter("credMax"));
		double radius = Double.parseDouble(request.getParameter("radius"));
		
		StringBuilder crimes = getService().getCrimesInRadius(lat, lng, radius, 
				initDateMilliSeconds, finalDateMilliSeconds, credibilidadeMin, credibilidadeMax);
		double perigo;
		if(radius <= 0.8f) {
			AvaliacaoPerigo avaliacaoPerigo = new AvaliacaoPerigo(getService());
			perigo = avaliacaoPerigo.avaliarCirculo(new PontoLatLng(lat, lng), radius, new Date(initDateMilliSeconds), credibilidadeMin, credibilidadeMax);
		} else {
			perigo = -1;
		}
		
		String userAgent = request.getHeader("User-Agent");
		MobileRequestLog mobileRequestLog = new MobileRequestLog(new Date(System.currentTimeMillis()), userAgent);
		getLogService().save(mobileRequestLog);
		
		PrintWriter writer = response.getWriter();
		writer.println(perigo + ";;;" + crimes);
		writer.close();
	}
	
	private CrimeService getService(){
		if(service == null){
			ApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			service = (CrimeService)springContext.getBean("crimeService");
		}
		return service;
	}
	
	private LogService getLogService(){
		if(logService == null){
			ApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			logService = (LogService)springContext.getBean("logService");
		}
		return logService;
	}
}