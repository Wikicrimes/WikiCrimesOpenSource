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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cripto {
	private static MessageDigest md;
	
	static {
		
		 try {
				md= MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		
	}
	
	private static char[] hexCodes(byte[] text) {

        char[] hexOutput = new char[text.length * 2];

        String hexString;

 

        for (int i = 0; i < text.length; i++) {

            hexString = "00" + Integer.toHexString(text[i]);

            hexString.toUpperCase().getChars(hexString.length() - 2,

                                    hexString.length(), hexOutput, i * 2);

        }

        return hexOutput;

	}
	public static String criptografar(String texto) {

        if (md != null) {

            return new String(hexCodes(md.digest(texto.getBytes())));

        }

        return null;

}

}
