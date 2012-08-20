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

import org.wikicrimes.model.EstatisticaEstado;
import org.wikicrimes.model.EstatisticaPais;

public interface EstatisticaEstadoDao extends GenericCrudDao {
	
	public List<EstatisticaEstado> getTopFiveEstados();
	public EstatisticaEstado getEstatisticaEstado(Long idEstatisticaEstado);
	public List<EstatisticaEstado> getEstadosDoPais(Long idEstatisticaPais);
	public EstatisticaEstado getEstatisticaEstado(String sigla);
	public EstatisticaPais getEstatisticaPais(String sigla);
	public String getNomeEstado(String sigla);
	public String getSiglaEstado(Long idEstatisticaPais);
	public Long getQtdUsuarios(String sigla);
	public Long getQtdCrimes(String sigla);
	public Long getQtdRoubos(String sigla);
	public Long getQtdRouboPessoa(String sigla);
	public Long getQtdRouboPropriedade(String sigla);
	public Long getQtdTentativaRouboPessoa(String sigla);
	public Long getQtdTentativaRouboPropriedade(String sigla);
	public Long getQtdFurto(String sigla);
	public Long getQtdFurtoPessoa(String sigla);
	public Long getQtdFurtoPropriedade(String sigla);
	public Long getQtdTentativaFurtoPessoa(String sigla);
	public Long getQtdTentativaFurtoPropriedade(String sigla);
	public Long getQtdOutros(String sigla);
	public Long getQtdOutrosRixas(String sigla);
	public Long getQtdOutrosViolenciaDomestica(String sigla);
	public Long getQtdOutrosAbusoAutoridade(String sigla);
	public Long getQtdOutrosHomicidio(String sigla);
	public Long getQtdOutrosTentativaHomicidio(String sigla);
	public Long getQtdOutrosLatrocinio(String sigla);
	public Long getQtdTurnoUm(String sigla);
	public Long getQtdTurnoDois(String sigla);
	public Long getQtdTurnoTres(String sigla);
	public Long getQtdTurnoQuatro(String sigla);
	public Double getLatitude(String sigla);
	public Double getLongitude(String sigla);
	public Long getQtdTentativaRoubo(String sigla);
	public Long getQtdTentativaFurto(String sigla);

}
