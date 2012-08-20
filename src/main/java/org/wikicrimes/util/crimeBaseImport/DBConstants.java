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
package org.wikicrimes.util.crimeBaseImport;

public class DBConstants{

	public static class TipoCrime{
		public static final Long TENTATIVA_DE_ROUBO = 1L; 
		public static final Long TENTATIVA_DE_FURTO = 2L; 
		public static final Long FURTO = 3L; 
		public static final Long ROUBO = 4L; 
		public static final Long VIOLENCIA = 5L; 
	}
	
	public static class SubtipoCrime{
		public static final Long PESSOA = 1L; 
		public static final Long PROPRIEDADE = 2L; 
		public static final Long RIXAS_OU_BRIGAS = 3L; 
		public static final Long VIOLENCIA_DOMESTICA = 4L; 
		public static final Long ABUSO_DE_AUTORIDADE = 5L;
		public static final Long HOMICIDIO = 6L;
		public static final Long TENTATIVA_DE_HOMICIDIO = 7L;
		public static final Long LATROCINIO = 8L;
		public static final Long ATENTADO_AO_PUDOR = 9L;
		public static final Long NAO_INFORMADO = 10L;
	}

	public static class LocalCrime{
		public static final Long PESSOA_VIA_PUBLICA = 1L;
		public static final Long PESSOA_TRANSPORTE_COLETIVO = 2L;
		public static final Long PESSOA_ESTABELECIMENTO_COMERCIAL = 3L;
		public static final Long PESSOA_RESIDENCIA = 4L;
		public static final Long PESSOA_ESCOLA = 5L;
		public static final Long PESSOA_OUTROS = 6L;
		public static final Long PROPRIEDADE_RESIDENCIA = 7L;
		public static final Long PROPRIEDADE_BANCO = 8L;
		public static final Long PROPRIEDADE_FARMACIA = 9L;
		public static final Long PROPRIEDADE_POSTO_GASOLINA = 10L;
		public static final Long PROPRIEDADE_LOTERICA = 11L;
		public static final Long PROPRIEDADE_VEICULO = 12L;
		public static final Long PROPRIEDADE_SHOPPING = 13L;
		public static final Long PESSOA_PRACA_PUBLICA= 14L;
		public static final Long PROPRIEDADE_OUTROS = 15L;
		public static final Long PROPRIEDADE_ESTABELECIMENTO_COMERCIAL = 16L;
		public static final Long PROPRIEDADE_CARGA = 17L;
	}
	
}
