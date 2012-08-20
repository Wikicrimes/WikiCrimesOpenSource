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
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.wikicrimes.model.AreaRisco;
import org.wikicrimes.model.PontoLatLng;
import org.wikicrimes.model.Usuario;
import org.wikicrimes.service.AreaRiscoService;

/**
 * Trata requisi��es para persistir e recuperar poligionos de "Areas Risco"
 * 
 * @author victor
 */
public class ServletAreasRisco extends HttpServlet {

	private AreaRiscoService service;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String acao = req.getParameter("acao");
		if(acao != null){

			AreaRiscoService service = getService();
			HttpSession sessao = req.getSession();
			PrintWriter out = resp.getWriter();
			Usuario usuario = (Usuario)sessao.getAttribute("usuario");
			String idStr = req.getParameter("id");
			String nome = req.getParameter("nome");
			String verticeStr = req.getParameter("vertices");
			
			if(acao.equals("salvar")){
				AreaRisco area = new AreaRisco();
				area.setUsuario(usuario);
				area.setDataHoraRegistro(new Date());
				area.setNome(nome);
				List<PontoLatLng> vertices = area.setVerticesAndReturn(verticeStr); 
				service.save(vertices); //salva os pontos e tb coloca os pontos na area
				service.save(area);
				out.write(""+area.getIdAreaRisco());
			}else if(acao.equals("listar")){
				if(usuario != null){
					List<AreaRisco> areas = service.listAreas(usuario);
					out.print(AreaRisco.listToString(areas));
				}
			}else if(acao.equals("renomear")){
				AreaRisco area = (AreaRisco)service.get(Long.valueOf(idStr));
				area.setNome(nome);
				service.update(area);
			}else if(acao.equals("alterarFormato")){
				AreaRisco area = (AreaRisco)service.get(Long.valueOf(idStr));
				List<PontoLatLng> vertices = area.setVerticesAndReturn(verticeStr);
				service.save(vertices);
				service.update(area);
			}else if(acao.equals("excluir")){
				AreaRisco area = new AreaRisco();
				area.setIdAreaRisco(Long.valueOf(idStr));
				service.delete(area);
			}
			out.close();
		}
	}
	
	private AreaRiscoService getService(){
		if(service == null){
			ApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			service = (AreaRiscoService)springContext.getBean("areaRiscoService");
		}
		return service;
	}
	
}
