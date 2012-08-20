/**
 
    WikiCrimes.org is a project/software that allows posting and accessing criminal occurrences in a digital map.
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
var jaMostrouAlerta = false;
var jaMostrouNotificacoes = false;
var jaMostrouAjudaPesquisa = false;
var jaMostrouInteracaoMapa = false;
var jaMostrouTipoMapa = false;
function verificarRegras(situacao){
	var numAleatorio = geraNumero(1,100);
	if(situacao['tem_notificacoes']){		
		if(situacao['qtd_move_map']>=3){			
			if(!jaMostrouAjudaPesquisa && numAleatorio> 60){
				mostraBalaoPesquisaEndereco();
				return;
			}	
		}
		if(situacao['qtd_move_map']>=5){
			
			if(!jaMostrouInteracaoMapa && numAleatorio> 60){
				mostrarBalaoInteracaoMapa()
				return;
			}	
		}
		if(situacao['zoom']>=15 && map.getMapTypeId() != google.maps.MapTypeId.SATELLITE){
			
			if(!jaMostrouTipoMapa && numAleatorio> 40){
				mostrarBalaoTipoMapa();
				return;
			}	
		}
	}else{		
		if(numAleatorio <= 50){
			if(!jaMostrouAlerta){
				mostraBalaoAlertarAmigos();
				return;
			}	
		}else if(!jaMostrouNotificacoes){
			mostraBalaoNotificacoes();
			return;
		}	
			
	
		if(situacao['qtd_move_map']>=2){
			
			if(!jaMostrouAjudaPesquisa && numAleatorio> 60){
				mostraBalaoPesquisaEndereco();
				return;
			}	
		}
		if(situacao['qtd_move_map']>=4){
			
			if(!jaMostrouInteracaoMapa && numAleatorio> 80){
				mostrarBalaoInteracaoMapa()
				return;
			}	
		}
		if(situacao['zoom']>=15 && map.getMapTypeId() != google.maps.MapTypeId.SATELLITE){
			
			if(!jaMostrouTipoMapa && numAleatorio> 40){
				mostrarBalaoTipoMapa();
				return;
			}	
		}
	}	
}

function mostraBalaoAlertarAmigos(){
	criaBalaoSetaCima(prefs.getMsg("balao.ajuda.alertar"),conteudoAjudaRelacionadaNotificacoes());
	if(opensocial.getEnvironment().getDomain() == 'orkut.com')
		mostrarBalao('360px','40px');
	else
		mostrarBalao('360px','12px');
	jaMostrouAlerta = true;
}

function mostraBalaoPesquisaEndereco(){
	criaBalaoSetaCima(prefs.getMsg("balao.ajuda.pesquisar.endereco"),conteudoSemAjudaRelacionada());
	if(opensocial.getEnvironment().getDomain() == 'orkut.com')
		mostrarBalao('560px','32px');
	else
		mostrarBalao('542px','10px');
	
	jaMostrouAjudaPesquisa = true;
}

function mostraBalaoNotificacoes(){
	criaBalaoSetaCima(prefs.getMsg("balao.ajuda.notificacoes"),conteudoAjudaRelacionadaRegistrarAlerta());
	if(opensocial.getEnvironment().getDomain() == 'orkut.com')
		mostrarBalao('148px','82px');
	else
		mostrarBalao('148px','48px');
	
	jaMostrouNotificacoes = true;
}

function mostrarBalaoInteracaoMapa(){
	criaBalaoSetaCima(prefs.getMsg("balao.ajuda.manipulacao.mapa"),conteudoSemAjudaRelacionada());
	if(opensocial.getEnvironment().getDomain() == 'orkut.com')
		mostrarBalao('316px','150px');
	else
		mostrarBalao('292px','68px');
	jaMostrouInteracaoMapa = true;
}

function mostrarBalaoTipoMapa(){
	criaBalaoSetaCima(prefs.getMsg("balao.ajuda.tipo.mapa"),conteudoSemAjudaRelacionada());
	if(opensocial.getEnvironment().getDomain() == 'orkut.com')	
		mostrarBalao('582px','82px');
	else
		mostrarBalao('520px','58px');
	jaMostrouTipoMapa = true;
}

function alterarEstadoSituacao(situacao){
	if(tutorEstaAtivado)	
		verificarRegras(situacao);
}

function geraNumero(inferior,superior){
    var numPossibilidades = superior - inferior;
    var aleat = Math.random() * numPossibilidades;
    aleat = Math.floor(aleat);
    return parseInt(inferior) + aleat;
}

function desabilitaTutor(time){
	var flag = false;
	if(tutorEstaAtivado){
		tutorEstaAtivado = false;
		flag = true;
	}	
	setTimeout(function(){
		if(flag)
			tutorEstaAtivado = true; 
	},time);
}