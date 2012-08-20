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
package org.wikicrimes.web;

import java.util.Locale;
import java.util.Map;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;

import org.wikicrimes.util.CookiesHelper;

public class LocaleForm extends GenericForm{

	    public String MudaLocale(){
	        FacesContext context=FacesContext.getCurrentInstance();
	        String languageCode=getLanguageCode(context);
	        context.getViewRoot().setLocale(new Locale(languageCode));
	        Cookie c =CookiesHelper.getCookie("wikicrimes.locale");
	        sessionScope.put("wikicrimes.locale", languageCode);
	        if (c != null) {
	        	if (!c.getValue().equals(languageCode))
	        		CookiesHelper.addCookie("wikicrimes.locale", languageCode, Integer.MAX_VALUE);
	        }
	        else 
	        	CookiesHelper.addCookie("wikicrimes.locale", languageCode, Integer.MAX_VALUE);

	        return null;
	    }

	    private String getLanguageCode(FacesContext context){
	        Map<String,String>params=context.getExternalContext()
	        .getRequestParameterMap();
	        return params.get("languageCode");

	    }
	    public Locale getLocaleAtual() {
	        FacesContext context = FacesContext.getCurrentInstance();
	        UIViewRoot viewRoot = context.getViewRoot();
	        Locale localeAtual = viewRoot.getLocale();
	        return localeAtual;
	    }

	 
	
	/*private static final List<SelectItem> LOCALES;

	static {
		LOCALES = new ArrayList<SelectItem>(2);
		LOCALES.add(new SelectItem("pt_BR", "Portugues"));
		LOCALES.add(new SelectItem("en", "English"));
	}
	private String locale = "pt_BR";

	public String getLocale() {
		return locale;
	}
	public String getBrazil() {
		 FacesContext context = FacesContext.getCurrentInstance();
		    context.getViewRoot().setLocale(Locale.ENGLISH);
		    return null;
	}

	
	public void setLocale(String locale) {
		this.locale = locale;
	}

	public List<SelectItem> getLocaleList() {
		return LOCALES;
	}

	public void changeLocale(ValueChangeEvent event) {
		locale = event.getNewValue().toString();
		this.getFacesContext().getCurrentInstance().getViewRoot().setLocale(
				new Locale(locale));
	}*/

}
