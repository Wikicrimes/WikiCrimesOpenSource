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
function mostrarBalao(leftRight, top, tipoDiv){
	var divBalao = document.getElementById(tipoDiv);	
	divBalao.style.visibility = "visible";
	divBalao.style.top = top;
	if(tipoDiv == "divBalaoTutorEsquerda")
		divBalao.style.left = leftRight;
	else
		divBalao.style.right = leftRight;
}

function criaBalaoSetaCima(conteudoTexto, conteudoAcoesRelacionadas, tipoDiv){
	fecharBalao();
	var htmlBalao = '<div id="topoBalaoSetaCima"><a style="color: blue; text-decoration: none; background-color: transparent" onclick="fecharBalao();">X</a></div>'+	
			'<div align="justify" id="meioBalaoSetaCima">'+conteudoTexto+conteudoAcoesRelacionadas+'</div>'+
			'<div id="baseBalaoSetaCima"></div>';	
	document.getElementById(tipoDiv).innerHTML = htmlBalao;
}

function criaBalaoSetaBaixo(conteudoTexto, conteudoAcoesRelacionadas, tipoDiv){
	fecharBalao();
	var htmlBalao = '<div id="topoBalaoSetaBaixo"><a style="color: blue; text-decoration: none; background-color: transparent" onclick="fecharBalao();">X</a></div>'+	
			'<div align="justify" id="meioBalaoSetaBaixo">'+conteudoTexto+conteudoAcoesRelacionadas+'</div>'+
			'<div id="baseBalaoSetaBaixo"></div>';	
	document.getElementById(tipoDiv).innerHTML = htmlBalao;
}