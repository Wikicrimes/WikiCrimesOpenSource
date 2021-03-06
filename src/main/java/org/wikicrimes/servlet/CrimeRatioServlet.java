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
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.wikicrimes.model.Usuario;
import org.wikicrimes.service.CrimeService;
import org.wikicrimes.service.GoogleEnderecoService;
import org.wikicrimes.service.UsuarioService;
import org.wikicrimes.util.GoogleMapsData;
/**
 * Tendo uma coordenada de lat e long, vc pegara todos os crimes de um dado raio
 * passado... Obj gerar uma circunferencia virtual que mapei esses pontos...retorna um dado no formato XML!
 * 
 * @author philipp
 *
 */
public class CrimeRatioServlet extends HttpServlet {

	private static final long serialVersionUID = 3220671688900369774L;
	private GoogleEnderecoService ges = new GoogleEnderecoService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
		contaCrimesArea(request,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		contaCrimesArea(req,resp);
	}
	
	private void contaCrimesArea(HttpServletRequest request,HttpServletResponse response){
		try{
			
			ApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			CrimeService crimeService = (CrimeService)springContext.getBean("crimeService");
			UsuarioService usuarioService = (UsuarioService)springContext.getBean("usuarioService");
			
			String serv = request.getParameter("serv");
			String id = request.getParameter("id");
			
			//verifica se o user foi autenticado ignora o resto do metodo!
			if(serv != null && serv.equalsIgnoreCase("disp")){
				if(id != null){
					//falta fazer
					boolean ativado=crimeService.realizaAtivacao(id);
					
					if(ativado){
						parsingToXML(response,"pha");//servico ativo 'liberado'
					}else{
						parsingToXML(response,"phd");//servico desativado 'trava'
					}
				}
				return;
			}
			
			String latStr = request.getParameter("lat"),longStr = request.getParameter("long");
			String end = request.getParameter("end");
			
			double latitude = 0.0;
			double longitude = 0.0;
			
			if(latStr.equalsIgnoreCase("vaz") && longStr.equalsIgnoreCase("vaz")){
				GoogleMapsData coord = ges.consultaRuaURL(end);
				
				latitude=coord.getLatitude();
				longitude=coord.getLongitude();
				end=coord.getEndereco();
				
			}else{
				//a lat existe
				latitude = Double.parseDouble(latStr);
				longitude = Double.parseDouble(longStr);
				end = ges.consultaRuaCoordenadas(latitude+","+longitude).getEndereco();
			}
			
			if(end==null){
				errorXML(response);
			}else{
				double raio = Double.parseDouble(request.getParameter("raio"));
				long dataIni = Long.parseLong(request.getParameter("dIni"));
				long dataFim = Long.parseLong(request.getParameter("dFim"));
				
				//manda pro crimeService...
				Map <String,Integer> mapa = crimeService.numeroCrimesArea(latitude, longitude, raio,dataIni,dataFim);
				
				//conta as requisicoes feita pelo usuario, esse obj retornado jah vem contado...
				Usuario user = usuarioService.getUsuarioKey(id);//traz o id
				if(user!=null){
					usuarioService.update(user);
				}
				//monta o xml de resposta
				parsingToXML(mapa,response,end);
			}
			
		}catch(IOException e){
			errorXML(response);
		}catch(XMLStreamException e){
			errorXML(response);
		}catch(FactoryConfigurationError e){
			errorXML(response);
		}catch(Exception e){
			errorXML(response);
			e.printStackTrace();
		}
	}
	
	private void errorXML(HttpServletResponse response){
		
		response.setContentType("text/xml; charset=iso-8859-1");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		
		StringBuilder error = new StringBuilder();
		
		error.append("<?xml version='1.0' encoding='iso-8859-1'?>");
		error.append("<crimes>");
		error.append("<errors>Error</errors>");
		error.append("</crimes>");
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(error.toString());
			out.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private void parsingToXML(HttpServletResponse response,String disp) throws IOException{
		
		response.setContentType("text/xml; charset=iso-8859-1");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setCharacterEncoding("UTF-8");
		
		StringBuilder sbXML = new StringBuilder();
		
		sbXML.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbXML.append("<cr>");
		sbXML.append("<a>"+disp+"</a>");
		sbXML.append("</cr>");
		
		PrintWriter out = response.getWriter();
		out.println(sbXML.toString());
		out.close();
	}
	
	private void parsingToXML(Map <String,Integer> mapa,HttpServletResponse response,String end) throws IOException{
		
		response.setContentType("text/xml; charset=iso-8859-1");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		//response.setCharacterEncoding("iso-8859-1");
		response.setCharacterEncoding("UTF-8");
		
		StringBuilder sbXML = new StringBuilder();
		
		sbXML.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbXML.append("<cr>");
		sbXML.append("<f>"+mapa.get("Furto")+"</f>");
		sbXML.append("<r>"+mapa.get("Roubo")+"</r>");
		sbXML.append("<latr>"+mapa.get("Latrocinio")+"</latr>");
		sbXML.append("<ho>"+mapa.get("Homic�dio")+"</ho>");
		sbXML.append("<ou>"+mapa.get("Outros")+"</ou>");
		sbXML.append("<en>"+end+"</en>");
		sbXML.append("</cr>");
		
		PrintWriter out = response.getWriter();
		out.println(sbXML.toString());
		out.close();
	}
}
