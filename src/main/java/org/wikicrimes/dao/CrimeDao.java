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
package org.wikicrimes.dao;

import java.util.List;
import java.util.Map;

import org.wikicrimes.model.BaseObject;
import org.wikicrimes.model.Crime;

public interface CrimeDao extends GenericCrudDao {

	public List<BaseObject> filter(Map parameters);
	public List<Crime> getByUser(Long idUsuario);
	public List<Crime> getByTipoPaginado(Long idTipoCrime, Long fr, Long mr);
	public void incrementaContador(Boolean tipo,Long idCrime);
	public void incrementaView(Long idCrime);
	public Integer getQTDCrimesAtivos();
	public List<Crime> getCrimesSemEstatisticas();
	public Integer getQtdCrimesByTipo(Long idTipoCrime);
	public Integer getQtdCrimesByDateInterval(int tipoCrime, String dataInicio, String dataFim);
	public Integer getQtdCrimesByDateIntervalPais(final int tipoCrime, final String dataInicio, final String dataFim, final String siglaPais);
	public Integer getQtdCrimesByDateIntervalEstado(final int tipoCrime, final String dataInicio, final String dataFim, final String siglaEstado);
	public Integer getQtdCrimesByDateIntervalCidade(final int tipoCrime, final String dataInicio, final String dataFim, final String nomeCidade);
	public List<Crime> getCrimesSemChave();
	public List<Crime> getCrime(String chave);
	public List<Crime> getCrimesByViewPort(final double norte, final double sul, final double leste, final double oeste);
	public List<Crime> pesquisarCrime(Crime crime);
	public List<Crime> getCrimesMaisVistos();
	public List<Crime> getCrimesMaisComentados();
	public List<Crime> getCrimesMaisConfirmados();
	public void atualizaContadorCometarios(String idCrime);
	public Map<String,Integer> contaCrimesArea(double latitude, double longitude, double raio,long dataIni, long dataFim);
	public StringBuilder getCrimesInRadius(double latitude, double longitude, double raio,long dataIni, long dataFim, double credibilidadeMin, double credibilidadeMax);
	public boolean realizaAtivacao(String codApp);
}
