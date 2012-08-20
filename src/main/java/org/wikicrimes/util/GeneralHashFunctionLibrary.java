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

/*
 **************************************************************************
 *                                                                        *
 *          General Purpose Hash Function Algorithms Library              *
 *                                                                        *
 * Author: Arash Partow - 2002                                            *
 * URL: http://www.partow.net                                             *
 * URL: http://www.partow.net/programming/hashfunctions/index.html        *
 *                                                                        *
 * Copyright notice:                                                      *
 * Free use of the General Purpose Hash Function Algorithms Library is    *
 * permitted under the guidelines and in accordance with the most current *
 * version of the Common Public License.                                  *
 * http://www.opensource.org/licenses/cpl1.0.php                          *
 *                                                                        *
 **************************************************************************
*/


public class GeneralHashFunctionLibrary
{


   public long RSHash(String str)
   {
      int b     = 378551;
      int a     = 63689;
      long hash = 0;

      for(int i = 0; i < str.length(); i++)
      {
         hash = hash * a + str.charAt(i);
         a    = a * b;
      }

      return hash;
   }
   /* End Of RS Hash Function */


   public long JSHash(String str)
   {
      long hash = 1315423911;

      for(int i = 0; i < str.length(); i++)
      {
         hash ^= ((hash << 5) + str.charAt(i) + (hash >> 2));
      }

      return hash;
   }
   /* End Of JS Hash Function */


   public long PJWHash(String str)
   {
      long BitsInUnsignedInt = (long)(4 * 8);
      long ThreeQuarters     = (long)((BitsInUnsignedInt  * 3) / 4);
      long OneEighth         = (long)(BitsInUnsignedInt / 8);
      long HighBits          = (long)(0xFFFFFFFF) << (BitsInUnsignedInt - OneEighth);
      long hash              = 0;
      long test              = 0;

      for(int i = 0; i < str.length(); i++)
      {
         hash = (hash << OneEighth) + str.charAt(i);

         if((test = hash & HighBits)  != 0)
         {
            hash = (( hash ^ (test >> ThreeQuarters)) & (~HighBits));
         }
      }

      return hash;
   }
   /* End Of  P. J. Weinberger Hash Function */


   public long ELFHash(String str)
   {
      long hash = 0;
      long x    = 0;

      for(int i = 0; i < str.length(); i++)
      {
         hash = (hash << 4) + str.charAt(i);

         if((x = hash & 0xF0000000L) != 0)
         {
            hash ^= (x >> 24);
         }
         hash &= ~x;
      }

      return hash;
   }
   /* End Of ELF Hash Function */


   public long BKDRHash(String str)
   {
      long seed = 131; // 31 131 1313 13131 131313 etc..
      long hash = 0;

      for(int i = 0; i < str.length(); i++)
      {
         hash = (hash * seed) + str.charAt(i);
      }

      return hash;
   }
   /* End Of BKDR Hash Function */


   public long SDBMHash(String str)
   {
      long hash = 0;

      for(int i = 0; i < str.length(); i++)
      {
         hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash;
      }

      return hash;
   }
   /* End Of SDBM Hash Function */


   public long DJBHash(String str)
   {
      long hash = 5381;

      for(int i = 0; i < str.length(); i++)
      {
         hash = ((hash << 5) + hash) + str.charAt(i);
      }

      return hash;
   }
   /* End Of DJB Hash Function */


   public long DEKHash(String str)
   {
      long hash = str.length();

      for(int i = 0; i < str.length(); i++)
      {
         hash = ((hash << 5) ^ (hash >> 27)) ^ str.charAt(i);
      }

      return hash;
   }
   /* End Of DEK Hash Function */


   public long BPHash(String str)
   {
      long hash = 0;

      for(int i = 0; i < str.length(); i++)
      {
         hash = hash << 7 ^ str.charAt(i);
      }

      return hash;
   }
   /* End Of BP Hash Function */


   public long FNVHash(String str)
   {
      long fnv_prime = 0x811C9DC5;
      long hash = 0;

      for(int i = 0; i < str.length(); i++)
      {
      hash *= fnv_prime;
      hash ^= str.charAt(i);
      }

      return hash;
   }
   /* End Of FNV Hash Function */


   public long APHash(String str)
   {
      long hash = 0xAAAAAAAA;

      for(int i = 0; i < str.length(); i++)
      {
         if ((i & 1) == 0)
         {
            hash ^= ((hash << 7) ^ str.charAt(i) * (hash >> 3));
         }
         else
         {
            hash ^= (~((hash << 11) + str.charAt(i) ^ (hash >> 5)));
         }
      }

      return hash;
   }
   /* End Of AP Hash Function */

}
