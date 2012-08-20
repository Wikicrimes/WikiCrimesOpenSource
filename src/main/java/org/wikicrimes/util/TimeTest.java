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

import java.util.ArrayList;
import java.util.List;

/**
 * @author victor
 * Pra medir o tempo de execução de trechos de código e identificar gargalos
 */
public class TimeTest {

	private static boolean on = true;
	private static List<Instant> instants;
	
	public static void start() {
		instants = new ArrayList<Instant>();
		saveInstant("start");
	}
	
	public static void saveInstant(String label) {
		long time = System.currentTimeMillis();
		instants.add(new Instant(time, label));
	}
	
	public static void print() {
		if(!on) return;
		long prevTime = instants.get(0).time;
		System.out.println("--------------------------------");
		for(int i=1; i<instants.size(); i++) {
			Instant in = instants.get(i);
			long dt = in.time - prevTime;
			System.out.printf("%20s   %d\n", in.label, dt);
			prevTime = in.time;
		}
		long tf = instants.get(instants.size()-1).time;
		long ti = instants.get(0).time;
		long total = tf - ti;
		System.out.printf("%20s   %d\n", "TOTAL", total);
	}

	private static class Instant{
		long time;
		String label;
		public Instant(long time, String label) {
			this.time = time;
			this.label = label;
		}
	}
	
}
