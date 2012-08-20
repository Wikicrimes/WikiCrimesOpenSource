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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateBDCacheEstatisticas {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/wikicrimes?user=" + args[0] + "&password=" + args[1]);  
		
		Statement stm = conn.createStatement();
		Statement stm2 = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT cri_idcrime, tcr_idtipo_crime, tvi_idtipo_vitima FROM tb_cri_crime ORDER BY cri_idcrime");
		while (rs.next()) { 
		    int crime = rs.getInt("cri_idcrime");  
		    int tipo = rs.getInt("tcr_idtipo_crime");
		    int vitima = rs.getInt("tvi_idtipo_vitima");
		    String ids = tipo + "|" + vitima + "|" ;
		    
			ResultSet rs2 = stm2.executeQuery("select crz_idrazao from tb_crz_crime_razao where crz_idcrime = " + crime + " order by crz_idrazao");
			while (rs2.next()) {  
			    int razao = rs2.getInt("crz_idrazao");
			    ids += razao + ",";
			}
			ids = ids.substring(0, ids.length()-1);
			
		    stm2.executeUpdate("UPDATE tb_cri_crime SET cri_cache_estatisticas='" + ids + "' WHERE cri_idcrime=" + crime );
		    
		}
	}
}
