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
package org.wikicrimes.model;

import java.util.Set;

public class EstatisticaPais extends BaseObject {
	
	private static final long serialVersionUID = 1649533906191866272L;

	private Long idEstatisticaPais;
	private String nome;
	private String sigla;
	private Long quantidadeUsuarios;
	private Long quantidadeCrimes;
	private Set<EstatisticaEstado> estados;
	
	private Long quantidadeRoubos;
	private Long qtdRouboPessoa;
	private Long qtdRouboPropriedade;
	private Long qtdTentativaRouboPessoa;
	private Long qtdTentativaRouboPropriedade;
	
	private Long qtdTentativaRoubo;
	private Long qtdTentativaFurto;

	private Long quantidadeFurtos;
	private Long qtdFurtoPessoa;
	private Long qtdFurtoPropriedade;
	private Long qtdTentativaFurtoPessoa;
	private Long qtdTentativaFurtoPropriedade;

	private Long quantidadeOutros;
	private Long qtdOutroRixas;
	private Long qtdOutroViolenciaDomestica;
	private Long qtdOutroAbusoAutoridade;
	private Long qtdOutroHomicidio;
	private Long qtdOutroTentativaHomicidio;
	private Long qtdOutroLatrocinio;
	
	private Long qtdTurnoUm;
	private Long qtdTurnoDois;
	private Long qtdTurnoTres;
	private Long qtdTurnoQuatro;
	
	private Double latitude;
	private Double longitude;


	public EstatisticaPais() {
		// TODO Auto-generated constructor stub
	}
	
	public EstatisticaPais(Long idEstatisticaPais) {
		this.idEstatisticaPais = idEstatisticaPais;
	}

	public Long getIdEstatisticaPais() {
		return idEstatisticaPais;
	}

	public void setIdEstatisticaPais(Long idEstatisticaPais) {
		this.idEstatisticaPais = idEstatisticaPais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getQuantidadeCrimes() {
		return quantidadeCrimes;
	}

	public void setQuantidadeCrimes(Long quantidadeCrimes) {
		this.quantidadeCrimes = quantidadeCrimes;
	}

	public Long getQuantidadeUsuarios() {
		return quantidadeUsuarios;
	}

	public void setQuantidadeUsuarios(Long quantidadeUsuarios) {
		this.quantidadeUsuarios = quantidadeUsuarios;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	
	public Long getQtdFurtoPessoa() {
		return qtdFurtoPessoa;
	}

	public void setQtdFurtoPessoa(Long qtdFurtoPessoa) {
		this.qtdFurtoPessoa = qtdFurtoPessoa;
	}

	public Long getQtdFurtoPropriedade() {
		return qtdFurtoPropriedade;
	}

	public void setQtdFurtoPropriedade(Long qtdFurtoPropriedade) {
		this.qtdFurtoPropriedade = qtdFurtoPropriedade;
	}

	public Long getQtdOutroAbusoAutoridade() {
		return qtdOutroAbusoAutoridade;
	}

	public void setQtdOutroAbusoAutoridade(Long qtdOutroAbusoAutoridade) {
		this.qtdOutroAbusoAutoridade = qtdOutroAbusoAutoridade;
	}

	public Long getQtdOutroHomicidio() {
		return qtdOutroHomicidio;
	}

	public void setQtdOutroHomicidio(Long qtdOutroHomicidio) {
		this.qtdOutroHomicidio = qtdOutroHomicidio;
	}

	public Long getQtdOutroLatrocinio() {
		return qtdOutroLatrocinio;
	}

	public void setQtdOutroLatrocinio(Long qtdOutroLatrocinio) {
		this.qtdOutroLatrocinio = qtdOutroLatrocinio;
	}

	public Long getQtdOutroRixas() {
		return qtdOutroRixas;
	}

	public void setQtdOutroRixas(Long qtdOutroRixas) {
		this.qtdOutroRixas = qtdOutroRixas;
	}

	public Long getQtdOutroTentativaHomicidio() {
		return qtdOutroTentativaHomicidio;
	}

	public void setQtdOutroTentativaHomicidio(Long qtdOutroTentativaHomicidio) {
		this.qtdOutroTentativaHomicidio = qtdOutroTentativaHomicidio;
	}

	public Long getQtdOutroViolenciaDomestica() {
		return qtdOutroViolenciaDomestica;
	}

	public void setQtdOutroViolenciaDomestica(Long qtdOutroViolenciaDomestica) {
		this.qtdOutroViolenciaDomestica = qtdOutroViolenciaDomestica;
	}

	public Long getQtdRouboPessoa() {
		return qtdRouboPessoa;
	}

	public void setQtdRouboPessoa(Long qtdRouboPessoa) {
		this.qtdRouboPessoa = qtdRouboPessoa;
	}

	public Long getQtdRouboPropriedade() {
		return qtdRouboPropriedade;
	}

	public void setQtdRouboPropriedade(Long qtdRouboPropriedade) {
		this.qtdRouboPropriedade = qtdRouboPropriedade;
	}

	public Long getQtdTentativaFurtoPessoa() {
		return qtdTentativaFurtoPessoa;
	}

	public void setQtdTentativaFurtoPessoa(Long qtdTentativaFurtoPessoa) {
		this.qtdTentativaFurtoPessoa = qtdTentativaFurtoPessoa;
	}

	public Long getQtdTentativaFurtoPropriedade() {
		return qtdTentativaFurtoPropriedade;
	}

	public void setQtdTentativaFurtoPropriedade(Long qtdTentativaFurtoPropriedade) {
		this.qtdTentativaFurtoPropriedade = qtdTentativaFurtoPropriedade;
	}

	public Long getQtdTentativaRouboPessoa() {
		return qtdTentativaRouboPessoa;
	}

	public void setQtdTentativaRouboPessoa(Long qtdTentativaRouboPessoa) {
		this.qtdTentativaRouboPessoa = qtdTentativaRouboPessoa;
	}

	public Long getQtdTentativaRouboPropriedade() {
		return qtdTentativaRouboPropriedade;
	}

	public void setQtdTentativaRouboPropriedade(Long qtdTentativaRouboPropriedade) {
		this.qtdTentativaRouboPropriedade = qtdTentativaRouboPropriedade;
	}

	public Long getQtdTurnoDois() {
		return qtdTurnoDois;
	}

	public void setQtdTurnoDois(Long qtdTurnoDois) {
		this.qtdTurnoDois = qtdTurnoDois;
	}

	public Long getQtdTurnoQuatro() {
		return qtdTurnoQuatro;
	}

	public void setQtdTurnoQuatro(Long qtdTurnoQuatro) {
		this.qtdTurnoQuatro = qtdTurnoQuatro;
	}

	public Long getQtdTurnoTres() {
		return qtdTurnoTres;
	}

	public void setQtdTurnoTres(Long qtdTurnoTres) {
		this.qtdTurnoTres = qtdTurnoTres;
	}

	public Long getQtdTurnoUm() {
		return qtdTurnoUm;
	}

	public void setQtdTurnoUm(Long qtdTurnoUm) {
		this.qtdTurnoUm = qtdTurnoUm;
	}

	public Long getQuantidadeFurtos() {
		return quantidadeFurtos;
	}

	public void setQuantidadeFurtos(Long quantidadeFurtos) {
		this.quantidadeFurtos = quantidadeFurtos;
	}

	public Long getQuantidadeOutros() {
		return quantidadeOutros;
	}

	public void setQuantidadeOutros(Long quantidadeOutros) {
		this.quantidadeOutros = quantidadeOutros;
	}

	public Long getQuantidadeRoubos() {
		return quantidadeRoubos;
	}

	public void setQuantidadeRoubos(Long quantidadeRoubos) {
		this.quantidadeRoubos = quantidadeRoubos;
	}
	
	public Set<EstatisticaEstado> getEstados() {
		return estados;
	}

	public void setEstados(Set<EstatisticaEstado> estados) {
		this.estados = estados;
	}

	public boolean equals(Object obj) {
		
		if (!(obj instanceof EstatisticaPais)) {
			return false;
		} else {
			EstatisticaPais estatisticaPais = (EstatisticaPais) obj;
			return estatisticaPais.getIdEstatisticaPais().equals(this.getIdEstatisticaPais());
		}

	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Long getQtdTentativaFurto() {
		return qtdTentativaFurto;
	}

	public void setQtdTentativaFurto(Long qtdTentativaFurto) {
		this.qtdTentativaFurto = qtdTentativaFurto;
	}

	public Long getQtdTentativaRoubo() {
		return qtdTentativaRoubo;
	}

	public void setQtdTentativaRoubo(Long qtdTentativaRoubo) {
		this.qtdTentativaRoubo = qtdTentativaRoubo;
	}
	
	

}
