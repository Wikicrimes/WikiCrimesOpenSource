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

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.wikicrimes.model.BaseObject;
import org.wikicrimes.model.Crime;
import org.wikicrimes.model.Delegacia;
import org.wikicrimes.model.Relato;
import org.wikicrimes.model.RelatoRazao;

public class CrimeStringBuilder{

	public static String buildString(List<BaseObject> events) {

		StringBuilder s = new StringBuilder();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Crime crime = null;
		Relato relato = null;
		Delegacia delegacia = null;
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i) instanceof Crime) {
				crime = (Crime) events.get(i);
				s.append(crime.getChave());
				s.append("|");
				s.append(crime.getTipoCrime().getIdTipoCrime());
				s.append("|");
				s.append(crime.getLatitude()); 
				s.append("|");
				s.append(crime.getLongitude());
				s.append("|");
				s.append(crime.getIdCrime()); 
				s.append("|");
				s.append(sdf.format(crime.getData()));
//				String desc10Letras = "";
//				if (crime.getDescricao().length() > 10)
//					desc10Letras = crime.getDescricao().substring(0, 10)
//							+ "...";
//				else
//					desc10Letras=crime.getDescricao().substring(0,crime.getDescricao().length());
//				s.append("|");
//				s.append(desc10Letras.replaceAll("\\|", "").replaceAll("\\\n", ""));
//				s.append("|");
//				s.append(crime.getVisualizacoes());
//				s.append("|");
//				s.append(crime.getQtdComentarios());
//				s.append("|");
//				s.append(crime.getConfirmacoesPositivas());
			}else if(events.get(i) instanceof Relato) {
				relato = (Relato) events.get(i);
				
				s.append(relato.getChave());
				s.append("|");
				s.append(relato.getTipoRelato());
				s.append("|");
				s.append(relato.getLatitude());
				s.append("|");
				s.append(relato.getLongitude());
				s.append("|");
				s.append(relato.getIdRelato()); 
				if (relato.getSubTipoRelato() != null) {
					s.append("|");
					s.append(relato.getSubTipoRelato());
				} else {
					s.append("|");
				}
				s.append("|");
				s.append(sdf.format(relato.getDataHoraRegistro()));
				
				Set<RelatoRazao> razoes =  relato.getRazoes();
				StringBuilder razoesTexto = new StringBuilder();
				if(razoes != null){
					for (Iterator<RelatoRazao> iterator = razoes.iterator(); iterator.hasNext();) {
						RelatoRazao relatoRazao = (RelatoRazao) iterator.next();
						razoesTexto.append(relatoRazao.getRazao().getIdRazao().toString());
						razoesTexto.append(",");
					}
				}
				s.append("|");
				s.append(razoesTexto);
			} else if (events.get(i) instanceof Delegacia){
				delegacia = (Delegacia) events.get(i);
				
				s.append(delegacia.getChave());
				s.append("|");
				s.append(delegacia.getTipoDelegacia());
				s.append("|");
				s.append(delegacia.getLatitude());
				s.append("|");
				s.append(delegacia.getLongitude());
			}
			s.append("\n");
		}

		return s.toString();
	}


}
