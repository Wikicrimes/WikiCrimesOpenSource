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
package org.wikicrimes.web;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * Comparator to allow comparing a List of beans and sorting decending on
 * a Date property.
 *
 * @author mraible
 */
public class BeanDateComparator  extends BeanComparator {
    private static final long serialVersionUID = -5496825158557972554L;
 
    public BeanDateComparator(String property) {
        super(property);
    }

    public int compare( Object o1, Object o2 ) {
        if ( getProperty() == null ) {
            // compare the actual objects
            return getComparator().compare( o1, o2 );
        }

        try {
            Object value1 = PropertyUtils.getProperty( o1, getProperty() );
            Object value2 = PropertyUtils.getProperty( o2, getProperty() );

            if (value1 == null) {
                return -1;
            } else if (value2 == null) {
                return 1;
            }
            
            int result = getComparator().compare( value1, value2 );
            if (result == 1) return -1;
            else return 1;
        }
        catch ( Exception e ) {
            throw new ClassCastException( e.toString() );
        }
    }
}
