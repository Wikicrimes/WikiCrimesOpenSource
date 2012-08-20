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

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



// Classe de conex�o - uso do padr�o Singleton
public class ConexaoBD {

	// Conex�o
	private static ConexaoBD conexaoBD;
	private static Connection conexao;
	
	

	private ConexaoBD() throws SQLException, ClassNotFoundException {
		Properties props=null;
		/*Leitura do arquivo properties*/  
		try{
			 URL urlArquivo = getClass().getClassLoader().getResource("/");    
		         
			FileInputStream fis = new FileInputStream(urlArquivo.getPath()+"jdbc.properties.wikimapps");  
			props = new Properties();
		    props.load(fis);  
		    fis.close();  
		}catch(IOException e){  
		    e.printStackTrace();  
		}  
		
		/*
		 * ODBC Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); conexao =
		 * DriverManager.getConnection("jdbc:odbc:" + aAliase, "root","");
		 */

		try {
			
			// Carregando o JDBC Driver
			String driverName = props.getProperty("jdbc.driverClassName");//"org.gjt.mm.mysql.Driver"; // MySQL MM JDBC
			
			// driver
			Class.forName(driverName);
			 

			// Criando a conex�o com o Banco de Dados
			/*String serverName = rb.getString("serverName");
			String mydatabase = "wikimapps";*/
			String url = props.getProperty("jdbc.url");//"jdbc:mysql://" + serverName + "/" + mydatabase; // a
			// JDBC
			// url
			String username = props.getProperty("jdbc.username");			
			String password = props.getProperty("jdbc.password");
			
			conexao = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			// Driver n�o encontrado
			System.out.println("O driver expecificado n�o foi encontrado.");
			e.printStackTrace();
		} catch (SQLException e) {
			// N�o est� conseguindo se conectar ao banco
			System.err.println("N�o foi poss�vel conectar ao Banco de Dados");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static ConexaoBD getConexaoBD() {
		if (conexao == null)
			try {
				conexaoBD = new ConexaoBD();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return conexaoBD;
	}
	

	public ResultSet enviarConsulta(String aComandoSQL) throws SQLException {
		return conexao.createStatement().executeQuery(aComandoSQL);
	}

	public int enviarComando(String aComandoSQL) throws SQLException {
		return conexao.createStatement().executeUpdate(aComandoSQL);
	}

	public int[] enviarComandos(String[] aComandosSQL) throws SQLException {
		Statement st = conexao.createStatement();
		st.clearBatch();
		for (int i = 0; i < aComandosSQL.length; i++) {
			st.addBatch(aComandosSQL[i]);
		}
		return st.executeBatch();
	}

	public static void fechaConexao() {
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexao = null;
	}

	

}