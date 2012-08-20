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
package org.wikicrimes.web.listeners;

import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.Cookie;

import org.wikicrimes.util.CookiesHelper;

public class LocalePhaseListener implements PhaseListener{
	private static final long serialVersionUID = -257630463765246905L;

	public void afterPhase(PhaseEvent event) {
/*		FacesContext context = event.getFacesContext().getCurrentInstance();
		String languageCode = (String) context.getExternalContext().getSessionMap().get("wikicrimes.locale");
		if (languageCode == null){
			Cookie cookie = CookiesHelper.getCookie("wikicrimes.locale");
			if (cookie != null) {
					context.getViewRoot().setLocale(new Locale(cookie.getValue()));
			}
		} 
		else{
			context.getViewRoot().setLocale(new Locale(languageCode));
		}
*/		
	}

	public void beforePhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext().getCurrentInstance();
		String languageCode = (String) context.getExternalContext().getSessionMap().get("wikicrimes.locale");
		if (languageCode == null){
			Cookie cookie = CookiesHelper.getCookie("wikicrimes.locale");
			if (cookie != null) {
					context.getViewRoot().setLocale(new Locale(cookie.getValue()));
			}
		} 
		else{
			context.getViewRoot().setLocale(new Locale(languageCode));
		}
			/*if (!context.getViewRoot().getViewId().equals("/filtro.xhtml") && !context.getViewRoot().getViewId().equals("/mostrarDados.xhtml")){
			Cookie cookie = CookiesHelper.getCookie("wikicrimes.locale");
			if (cookie != null) {
		
				context.getViewRoot().setLocale(new Locale(cookie.getValue()));
			}
		}*/
		
	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
