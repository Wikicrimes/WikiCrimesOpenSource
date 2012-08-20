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

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Description: Classe auxiliar para manipula��o de mensagens no contexto do Faces.
 * @author F�bio Barros
 */
public final class CookiesHelper {

    /**
	 * Construtor privado para impedir a instanciacao de um objeto. Forca
	 * utilizacao dos metodos na notacao estatica.
	 */
    private CookiesHelper() {
    }

    /**
     * Adiciona um cookie na resposta.
     * @param key Chave de identificacao do cookie
     * @param value Valor do cookie
     * @param age Tempo de vida do cookie
     */
    public static void addCookie(String key, String value, Integer age) {
    	// Criando o cookie
    	Cookie cookie = new Cookie(key, value);
    	if (age == null || age.equals(0)) {
    		cookie.setMaxAge(Integer.MAX_VALUE);
    	} else {
    		cookie.setMaxAge(age);
    	}
    	
    	// Armazenando o cookie
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		response.addCookie(cookie);
    }
    
    /**
     * Adiciona um cookie na resposta.
     * @param key Chave de identificacao do cookie
     * @return Cookie desejado
     */
    public static Cookie getCookie(String key) {
    	// Recuperando colecao de cookies
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    	HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    	if (request.getCookies() != null) {
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals(key)) {
				return cookie; 
			}
		}
    	}
		
		return null;
    }
}
