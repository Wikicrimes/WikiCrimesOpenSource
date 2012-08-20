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
package org.wikicrimes.dao.hibernate;

import java.util.List;

import org.wikicrimes.dao.EstatisticaEstadoDao;
import org.wikicrimes.model.EstatisticaEstado;
import org.wikicrimes.model.EstatisticaPais;

public class EstatisticaEstadoDaoHibernate extends GenericCrudDaoHibernate
		implements EstatisticaEstadoDao {

	public EstatisticaEstadoDaoHibernate() {
		setEntity(EstatisticaEstado.class);
	}

	public List<EstatisticaEstado> getEstadosDoPais(Long idEstatisticaPais) {
    	String query = "from EstatisticaEstado ";

    	if (idEstatisticaPais != null) {
    	    query += "where estatisticaPais = " + idEstatisticaPais;
    	}

    	return getHibernateTemplate().find(query);
		
	}
	
	public EstatisticaEstado getEstatisticaEstado(String sigla) {
    	String query = "from EstatisticaEstado ";

    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0); 		
	}
	
	public EstatisticaEstado getEstatisticaEstado(Long idEstatisticaEstado) {
    	String query = "from EstatisticaEstado ";

    	if (idEstatisticaEstado != null) {
    	    query += "where idEstatisticaEstado = " + idEstatisticaEstado;
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0);
	}

	public EstatisticaPais getEstatisticaPais(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getEstatisticaPais();
	}

	public String getSiglaEstado(Long idEstatisticaEstado) {
		String query = "from EstatisticaEstado ";
    	if (idEstatisticaEstado != null) {
    	    query += "where idEstatisticaEstado = " + idEstatisticaEstado;
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getSigla();
	}
	
	public String getNomeEstado(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getNome();
	}

	public Long getQtdCrimes(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQuantidadeCrimes();
	}

	public Long getQtdFurto(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQuantidadeFurtos();
	}

	public Long getQtdFurtoPessoa(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdFurtoPessoa();
	}

	public Long getQtdFurtoPropriedade(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdFurtoPropriedade();
	}

	public Long getQtdOutros(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQuantidadeOutros();
	}

	public Long getQtdOutrosAbusoAutoridade(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdOutroAbusoAutoridade();
	}

	public Long getQtdOutrosHomicidio(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdOutroHomicidio();
	}

	public Long getQtdOutrosLatrocinio(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdOutroLatrocinio();
	}

	public Long getQtdOutrosRixas(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdOutroRixas();
	}

	public Long getQtdOutrosTentativaHomicidio(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdOutroTentativaHomicidio();
	}

	public Long getQtdOutrosViolenciaDomestica(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdOutroViolenciaDomestica();
	}

	public Long getQtdRouboPessoa(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdRouboPessoa();
	}

	public Long getQtdRouboPropriedade(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdRouboPropriedade();
	}

	public Long getQtdRoubos(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQuantidadeRoubos();
	}

	public Long getQtdTentativaFurtoPessoa(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdTentativaFurtoPessoa();
	}

	public Long getQtdTentativaFurtoPropriedade(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdTentativaFurtoPropriedade();
	}

	public Long getQtdTentativaRouboPessoa(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdTentativaRouboPessoa();
	}

	public Long getQtdTentativaRouboPropriedade(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdTentativaRouboPropriedade();
	}

	public Long getQtdTurnoDois(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdTurnoDois();
	}

	public Long getQtdTurnoQuatro(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdTurnoQuatro();
	}

	public Long getQtdTurnoTres(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdTurnoTres();
	}

	public Long getQtdTurnoUm(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdTurnoUm();
	}

	public Long getQtdUsuarios(String sigla) {
		String query = "from EstatisticaEstado ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQuantidadeUsuarios();
	}

	public Double getLatitude(String sigla) {
		String query = "from EstatisticaPais ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getLatitude();
	}

	public Double getLongitude(String sigla) {
		String query = "from EstatisticaPais ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getLongitude();
	}
	
	public Long getQtdTentativaRoubo(String sigla){
		String query = "from EstatisticaPais ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdTentativaRoubo();
	}
	
	public Long getQtdTentativaFurto(String sigla){
		String query = "from EstatisticaPais ";
    	if (sigla != null) {
    	    query += "where sigla = '" + sigla + "'";
    	}
    	List<EstatisticaEstado> eE = getHibernateTemplate().find(query);
    	return eE.get(0).getQtdTentativaFurto();
	}
	
	public List<EstatisticaEstado> getTopFiveEstados() {
		String query = "from EstatisticaEstado order by EES_QTD_CRIMES desc";
		getHibernateTemplate().setMaxResults(5);
		List<EstatisticaEstado> resultado = getHibernateTemplate().find(query);
		getHibernateTemplate().setMaxResults(0);
		return resultado;
	}
}
