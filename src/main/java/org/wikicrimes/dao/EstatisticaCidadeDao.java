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

import org.wikicrimes.model.EstatisticaCidade;
import org.wikicrimes.model.EstatisticaEstado;

public interface EstatisticaCidadeDao extends GenericCrudDao {
	
	public List<EstatisticaCidade> getTopTenCidades();
	public List<EstatisticaCidade> getCidadesDoEstado(Long idEstatisticaEstado);
	public EstatisticaCidade getEstatisticaCidade(Long idEstatisticaCidade);
	public EstatisticaCidade getEstatisticaCidade(String nome);
	public String getNomeCidade(Long idEstatisticaCidade);
	public Long getQtdUsuarios(String nome);
	public Long getQtdCrimes(String nome);
	public Long getQtdRoubos(String nome);
	public Long getQtdRouboPessoa(String nome);
	public Long getQtdRouboPropriedade(String nome);
	public Long getQtdTentativaRouboPessoa(String nome);
	public Long getQtdTentativaRouboPropriedade(String nome);
	public Long getQtdFurto(String nome);
	public Long getQtdFurtoPessoa(String nome);
	public Long getQtdFurtoPropriedade(String nome);
	public Long getQtdTentativaFurtoPessoa(String nome);
	public Long getQtdTentativaFurtoPropriedade(String nome);
	public Long getQtdOutros(String nome);
	public Long getQtdOutrosRixas(String nome);
	public Long getQtdOutrosViolenciaDomestica(String nome);
	public Long getQtdOutrosAbusoAutoridade(String nome);
	public Long getQtdOutrosHomicidio(String nome);
	public Long getQtdOutrosTentativaHomicidio(String nome);
	public Long getQtdOutrosLatrocinio(String nome);
	public Long getQtdTurnoUm(String nome);
	public Long getQtdTurnoDois(String nome);
	public Long getQtdTurnoTres(String nome);
	public Long getQtdTurnoQuatro(String nome);
	public EstatisticaEstado getEstatisticaEstado(String nome);
	public Double getLatitude(String nome);
	public Double getLongitude(String nome);
	public Long getQtdTentativaRoubo(String nome);
	public Long getQtdTentativaFurto(String nome);

}
