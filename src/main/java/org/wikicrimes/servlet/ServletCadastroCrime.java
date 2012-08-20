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
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.wikicrimes.model.Crime;
import org.wikicrimes.model.Razao;
import org.wikicrimes.model.TipoArmaUsada;
import org.wikicrimes.model.TipoCrime;
import org.wikicrimes.model.TipoLocal;
import org.wikicrimes.model.TipoPapel;
import org.wikicrimes.model.TipoRegistro;
import org.wikicrimes.model.TipoVitima;
import org.wikicrimes.model.Usuario;
import org.wikicrimes.service.CrimeService;
import org.wikicrimes.service.UsuarioService;

public class ServletCadastroCrime extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		ApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		CrimeService crimeService = (CrimeService)springContext.getBean("crimeService");
		UsuarioService usuarioService = (UsuarioService)springContext.getBean("usuarioService");

		String externalToken = request.getParameter("externalToken");
		if(externalToken == null) {
			response.getWriter().print("error");
			return;
		}
		
		Usuario usuario = new Usuario();
		usuario.setExternalToken(externalToken);
		System.out.println("Usuario com o externalToken: "+externalToken);
		
		List usuarios = (List) usuarioService.find(usuario);
		
		if(usuarios.size()>0) {
			
			
			usuario = (Usuario) usuarios.get(0);
			
			Crime crime = new Crime();
			crime.setUsuario(usuario); //ok
			
			
			String desc = request.getParameter("desc");
			try {
				desc = URLDecoder.decode(desc, "UTF-8");
			} catch (Exception e) {}
			
			crime.setDescricao(desc); //ok
			
			crime.setLatitude(Double.parseDouble(request.getParameter("lat"))); //ok
			crime.setLongitude(Double.parseDouble(request.getParameter("lng"))); //ok
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				crime.setData(sdf.parse(request.getParameter("data"))); //ok
			} catch (ParseException e) {
				crime.setData(new Date());
				e.printStackTrace();
			}
			crime.setHorario(Long.parseLong(request.getParameter("periodo"))); //ok
			crime.setTipoArmaUsada(new TipoArmaUsada(Long.parseLong(request.getParameter("arma")))); //ok
			crime.setStatus(new Long(0)); //ok
			crime.setDataHoraRegistro(new Date()); //ok
			crime.setConfirmacoesNegativas(new Long(0)); //ok
			crime.setConfirmacoesPositivas(new Long(0)); //ok
			crime.setVisualizacoes(new Long(0)); //ok
			crime.setQtdComentarios(new Long(0)); //ok
			crime.setCacheEstatisticas(request.getParameter("tipoCrime")+"|"+request.getParameter("tipoVitima"));
			crime.setTipoRegistro(new TipoRegistro(new Long(4))); //ok (Nao Sei)			
			crime.setTipoPapel(new TipoPapel(Long.parseLong(request.getParameter("relacao")))); //ok
			crime.setTipoCrime(new TipoCrime(Long.parseLong(request.getParameter("tipoCrime")))); //ok
			crime.setTipoVitima(new TipoVitima(Long.parseLong(request.getParameter("tipoVitima")))); //ok
			crime.setTipoLocal(new TipoLocal(Long.parseLong(request.getParameter("local")))); //ok
						
			List<Razao> razoes = new ArrayList<Razao>();
			Razao razao = new Razao();
			razao.setIdRazao(new Long(20)); //ok (Nao Sei)
			razoes.add(razao);
						
			crimeService.insert(crime, razoes);
			
			response.getWriter().print("ok");
			System.out.println("ok");
		} else {
			response.getWriter().print("error");
			System.out.println("error");
		}		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doGet(request, response);
	}
}
