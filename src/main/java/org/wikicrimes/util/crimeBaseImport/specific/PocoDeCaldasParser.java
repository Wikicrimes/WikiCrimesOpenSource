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
package org.wikicrimes.util.crimeBaseImport.specific;


import static org.wikicrimes.util.crimeBaseImport.DBConstants.TipoCrime.TENTATIVA_DE_ROUBO;
import static org.wikicrimes.util.crimeBaseImport.DBConstants.TipoCrime.VIOLENCIA;
import static org.wikicrimes.util.crimeBaseImport.DBConstants.TipoCrime.ROUBO;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.wikicrimes.util.crimeBaseImport.Parser;
import org.wikicrimes.util.crimeBaseImport.IgnoredCrimeException;
import org.wikicrimes.util.crimeBaseImport.Model;
import jxl.*;
import jxl.read.biff.BiffException;

/* Parser para os crimes de Poço de Caldas.
 * Arquivo CV REDS detalhado -  wikcrimes.xls
 * Data : 8/8/12
 * Número REDS	
 * 
 * ORIGINAL									WIKICRIMES
 *  Data Fato  								CRI_DATA 
 * 	Horário Fato  							CRI_DATA( Deriva CRI_HORARIO) 
 * 	Município(Poços de Caldas) 				CRI_CIDADE 
 * 	Latitude  								CRI_LATITUDE 		
 * 	Longitude 	 							CRI_LONGITUDE 
 * 	Código Subclasse Nat Principal          -------------
 * 	Descrição Subclasse Nat Principal       CRI_DESCRICAO 
 * 	Tentado/Consumado Nat Principal 		-------------
 * 	Descrição Meio Utilizado 				CRI_DESCRICAO
 * 	Qtde Envolvidos 						CRI_QUANTIDADE 
 * 	Tipo Envolvimento 						-------------
 * 
 * 
 * @author Vladimir
 */

public class PocoDeCaldasParser extends Parser{

	public static final String DIR = "/home/vladimir/Transferências/";
	public static final String nomeDoArquivo = "CV REDS detalhado -  wikcrimes.xls";
	public static int linha = 0;
	public static int limite;
	
	public PocoDeCaldasParser(File file) throws IOException {
		
		super();
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(file);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(0);//primeira planilha
		limite = sheet.getRows();// numero de linhas da planilha
		linha = 4;//linha de comeco de leitura do arquivo
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected String getBaseName() {
		// TODO Auto-generated method stub
		return "pocos de caldas";
	}

	@Override
	protected String getBaseUrl() {
		// TODO Auto-generated method stub
		return "http://google.com";
	}
	
	protected static String[] split (String rawData)// Separa uma string com '
	{
		String[] dados = rawData.split("'");
		return dados;
	}

	@Override
	protected Model specificConvert(String rawData) throws ParseException, IgnoredCrimeException 
	{
		Model crime = new Model();
		String[] rawFields = PocoDeCaldasParser.split(rawData);
		crime.CRI_ID_ORIGINAL = rawFields[0];// Numero REDS
		crime.CRI_LATITUDE = Double.valueOf(rawFields[4].replace(',', '.')); 
		crime.CRI_LONGITUDE = Double.valueOf(rawFields[5].replace(',', '.'));
		crime.CRI_DATA = convertDate(rawFields[1],rawFields[2]);
		setAdressAndCEP(crime);
		setLocationFields(crime);
		convertCrime(crime,rawFields[7],rawFields[8]);
		setQuantEnvol(crime,rawFields);
		crime.CRI_DESCRICAO = rawFields[8] + rawFields[9];

		// TODO Auto-generated method stub	
		return crime;
	}
	
	protected void setAdressAndCEP(Model crime)// Seta o endereco 
	{
		
		String[] aux = getAddress(crime.CRI_LATITUDE, crime.CRI_LONGITUDE).split(",");
		crime.CRI_ENDERECO = "";
		for (int i = 0; i < 2 ; i++) {
			crime.CRI_ENDERECO += aux[i] +",";
		}
		
		aux = aux[aux.length-2].split("-");
		crime.CRI_CEP = aux[0] + aux[1];
		
		// TODO Auto-generated method stub
		
	}

	protected void setLocationFields(Model crime) //Seta a localizacao
	{
		crime.CRI_CIDADE = "Pocos de Caldas";
		crime.CRI_ESTADO = "Minas Gerais";
		crime.CRI_PAIS = "Brasil";
		// TODO Auto-generated method stub
		
	}

	protected void setQuantEnvol(Model crime, String[] rawFields) //Seta a quantidade de envolvidos
	{
		int quan = 0;
		for (int i = 0; i < rawFields.length ; i++) {
			if(rawFields[i].equals("AUTOR") || rawFields[i].equals("SUSPEITO"))
			{
				quan += Integer.valueOf(rawFields[i-1]);
			}
		}
		crime.CRI_QUANTIDADE = quan;
		// TODO Auto-generated method stub
		
	}

	protected void convertCrime(Model crime, String tipo, String consumado) // Tipo de crime
	{
		if(consumado.equals("CONSUMADO"))
		{
			if(tipo.equals("ROUBO"))
			{
				crime.TCR_IDTIPO_CRIME = ROUBO;
			}
			if(tipo.equals("ESTUPRO"))
			{
				crime.TCR_IDTIPO_CRIME = VIOLENCIA;
			}
			if(tipo.equals("HOMICIDIO"))
			{
				crime.TCR_IDTIPO_CRIME = VIOLENCIA;
				
			}
			if(tipo.equals("EXTORSAO MEDIANTE SEQUESTRO"))
			{
				crime.TCR_IDTIPO_CRIME = ROUBO;
			}	
		}
		
		else
		{
			if(tipo.equals("ROUBO"))
			{
				crime.TCR_IDTIPO_CRIME =  TENTATIVA_DE_ROUBO;
			}
			if(tipo.equals("ESTUPRO"))
			{
				crime.TCR_IDTIPO_CRIME = VIOLENCIA;
			}
			if(tipo.equals("HOMICIDIO"))
			{
				crime.TCR_IDTIPO_CRIME = VIOLENCIA;
				
			}
			if(tipo.equals("EXTORSAO MEDIANTE SEQUESTRO"))
			{
				crime.TCR_IDTIPO_CRIME = TENTATIVA_DE_ROUBO;
			}
		}
		// TODO Auto-generated method stub
		
	}

	protected Timestamp convertDate(String dma, String hora) throws ParseException// Converter para a data
	{
		String data = dma + " " + hora;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy H:mm:ss");
		Date date = df.parse(data);
		return new Timestamp(date.getTime());
		
		// TODO Auto-generated method stub
	}

	@Override
	public String next()  
	{
		if(linha >= limite)
			return null;
		
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(DIR,"CV REDS detalhado -  wikcrimes.xls"));
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheet = workbook.getSheet(0);

		int colunas = sheet.getColumns();

		String a = " ";
		String retorno = "";

		do
		{
			for (int j2 = 1; j2 < colunas; j2++) {
				
				if(!((a = sheet.getCell(j2,linha).getContents()).equals("")))
				{
					retorno += a + "'" ;
				}
				
			}
			linha ++;
			if(linha == limite)
				break;
			
		}
		while(sheet.getCell(1,linha).getContents().equals(""));

		// TODO Auto-generated method stub
		
		return retorno;
	}

	
	public String getAddress(String latlong)// Dada a latitude e longitude, retorna um endereco
	{
		String address = null;
		String gURL = "http://maps.google.com/maps/api/geocode/xml?latlng=" + latlong + "&sensor=false"; 
		try 
		{
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = df.newDocumentBuilder();
			Document dom = db.parse(gURL);
			Element docEl = dom.getDocumentElement();
			NodeList nl = docEl.getElementsByTagName("result");// Pega campos do formulario
			if (nl != null && nl.getLength() > 0)
			{
				address=((Element)nl.item(0)).getElementsByTagName("formatted_address").item(0).getTextContent();
				for(int i=0;i<nl.getLength();i++)
				{
					((Element)nl.item(i)).getElementsByTagName("formatted_address").item(0).getTextContent();
				}
			}
		} 
		catch (Exception ex) 
		{
			address = "Err";
		}
		return address;
	}
	public String getAddress(String lat, String lon) 
	{
		return getAddress(lat+ "," + lon);
	}
	public String getAddress(double lat, double lon) 
	{
		return getAddress("" + lat, "" + lon);
	}
}
