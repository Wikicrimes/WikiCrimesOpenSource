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
var estaRegistrandoArea = false;

//Comando dentro do mapa para mover
function ComandoMao() {
}
ComandoMao.prototype = new GControl();
var kernelEnabled = false;
ComandoMao.prototype.initialize = function(map) {
  var container = document.createElement("div");

  var maoDiv = document.createElement("div");
  this.setButtonStyle_(maoDiv);
  container.appendChild(maoDiv);
  maoDiv.appendChild(document.createTextNode(""));
  GEvent.addDomListener(maoDiv, "click", function() {
  	if(!estaDesenhandoArea){
  		selecionarComando(map, 'mao');
		setPodeRegistrar(false, 0);
		removerPoligono();
	}
  	document.getElementById("divTelaFiltro").style.visibility = "hidden";
  
  });
  
  GEvent.addDomListener(maoDiv, "mouseover", function() {
  		
  });
  
  GEvent.addDomListener(maoDiv, "mouseout", function() {  		
  		
  });
     
  map.getContainer().appendChild(container);
  return container;
}


ComandoMao.prototype.getDefaultPosition = function() {
  return new GControlPosition(G_ANCHOR_TOP_LEFT, new GSize(80,7));
}


ComandoMao.prototype.setButtonStyle_ = function(button) {
  //button.style.textDecoration = "underline";
 // button.style.color = "#0000cc";
  //button.style.backgroundColor = "white";
  //button.style.font = "small Arial";
  //button.style.border = "1px solid black";
  //button.style.padding = "2px";
  //button.style.marginBottom = "3px";
  //button.style.textAlign = "center";
  button.style.width = "7.42em";
  button.style.height = "2.68em";
  button.style.cursor = "pointer";
  button.style.backgroundImage = "url('./images/comandoMao_"+localeWikiCrimes+".png')";
}

function ComandoFiltro() {
}
ComandoFiltro.prototype = new GControl();

ComandoFiltro.prototype.initialize = function(map) {
  var container = document.createElement("div");

  var filtroDiv = document.createElement("div");
  this.setButtonStyle_(filtroDiv);
  container.appendChild(filtroDiv);
  filtroDiv.appendChild(document.createTextNode(""));
  GEvent.addDomListener(filtroDiv, "click", function() {
	  selecionarComando(map, 'filtro');
	  mostrarFiltro();
  });
  
  GEvent.addDomListener(filtroDiv, "mouseover", function() {
  		mostraHintComandosMapa("tutor.texto.filtro", "178px", "134px");
  });
  
  GEvent.addDomListener(filtroDiv, "mouseout", function() {  		
  		removeHintComandosMapa();
  });
     
  map.getContainer().appendChild(container);
  return container;
}


ComandoFiltro.prototype.getDefaultPosition = function() {
  return new GControlPosition(G_ANCHOR_TOP_LEFT, new GSize(80,40));
}


ComandoFiltro.prototype.setButtonStyle_ = function(button) {
  //button.style.textDecoration = "underline";
 // button.style.color = "#0000cc";
  //button.style.backgroundColor = "white";
  //button.style.font = "small Arial";
  //button.style.border = "1px solid black";
  //button.style.padding = "2px";
  //button.style.marginBottom = "3px";
  //button.style.textAlign = "center";
  button.style.width = "7.42em";
  button.style.height = "2.68em";
  button.style.cursor = "pointer";
  button.style.backgroundImage = "url('./images/comandoFiltro_"+localeWikiCrimes+".png')";
}

function ComandoFiltroSelecionado() {
}
ComandoFiltroSelecionado.prototype = new GControl();

ComandoFiltroSelecionado.prototype.initialize = function(map) {
  var container = document.createElement("div");

  var filtroDiv = document.createElement("div");
  this.setButtonStyle_(filtroDiv);
  container.appendChild(filtroDiv);
  filtroDiv.appendChild(document.createTextNode(""));
  GEvent.addDomListener(filtroDiv, "click", function() {  		
		selecionarComando(map, 'mao');
		esconderFiltro();
  });
  GEvent.addDomListener(filtroDiv, "mouseover", function() {
	  mostraHintComandosMapa("tutor.texto.filtro", "178px", "134px");
  });
  
  GEvent.addDomListener(filtroDiv, "mouseout", function() {  		
  		removeHintComandosMapa();
  });    
  map.getContainer().appendChild(container);
  return container;
}


ComandoFiltroSelecionado.prototype.getDefaultPosition = function() {
  return new GControlPosition(G_ANCHOR_TOP_LEFT, new GSize(80,40));
}

ComandoFiltroSelecionado.prototype.setButtonStyle_ = function(button) {
	  //button.style.textDecoration = "underline";
	  //button.style.color = "#0000cc";
	  //button.style.backgroundColor = "white";
	  //button.style.font = "small Arial";
	  //button.style.border = "1px solid black";
	  //button.style.padding = "2px";
	  //button.style.marginBottom = "3px";
	  //button.style.textAlign = "center";
	  button.style.width = "7.42em";
	  button.style.height = "2.68em";
	  button.style.cursor = "pointer";
	  button.style.backgroundImage = "url('./images/comandoFiltroSel_"+localeWikiCrimes+".png')";
	}



//Comando dentro do mapa para marcar uma area
function ComandoMarcadorDeArea() {
}
ComandoMarcadorDeArea.prototype = new GControl();

ComandoMarcadorDeArea.prototype.initialize = function(map) {
  var container = document.createElement("div");

  var marcarAreaDiv = document.createElement("div");
  this.setButtonStyle_(marcarAreaDiv);
  container.appendChild(marcarAreaDiv);
  marcarAreaDiv.appendChild(document.createTextNode(""));
  GEvent.addDomListener(marcarAreaDiv, "click", function() {
  	if(!estaRegistrandoArea){
  		
	  	//selecionarComando(map, 'area');	   
	    registrarArea1();
	}    
    //var label = new ELabel(polyListArea.getVertex(0), '<div style="background-color:#ffffff;border:1px solid blue;color:blue;width:120px;height:14px"> Marque os pontos de sua area no mapa </div>', null, new GSize(6,-10), 75);
  });
  
  GEvent.addDomListener(marcarAreaDiv, "mouseover", function() {
  		mostraHintComandosMapa("webapp.area.erro.info.hint.area", "138px", "268px");
  });
  
  GEvent.addDomListener(marcarAreaDiv, "mouseout", function() {  		
  		removeHintComandosMapa();
  });    

  map.getContainer().appendChild(container);
  return container;
}


ComandoMarcadorDeArea.prototype.getDefaultPosition = function() {
  return new GControlPosition(G_ANCHOR_TOP_LEFT, new GSize(170,7));
}


ComandoMarcadorDeArea.prototype.setButtonStyle_ = function(button) {
  //button.style.textDecoration = "underline";
 // button.style.color = "#0000cc";
  //button.style.backgroundColor = "white";
  //button.style.font = "small Arial";
  //button.style.border = "1px solid black";
  //button.style.padding = "2px";
  //button.style.marginBottom = "3px";
  //button.style.textAlign = "center";
  button.style.width = "7.42em";
  button.style.height = "2.68em";
  button.style.cursor = "pointer";
  button.style.backgroundImage = "url('./images/comandoArea_"+localeWikiCrimes+".png')";
}

//Comando dentro do mapa para mover
function ComandoMaoSelecionado() {
}
ComandoMaoSelecionado.prototype = new GControl();

ComandoMaoSelecionado.prototype.initialize = function(map) {
  var container = document.createElement("div");

  var maoDiv = document.createElement("div");
  this.setButtonStyle_(maoDiv);
  container.appendChild(maoDiv);
  maoDiv.appendChild(document.createTextNode(""));
  GEvent.addDomListener(maoDiv, "click", function() {  		
		selecionarComando(map, 'mao');
		setPodeRegistrar(false, 0);
		removerPoligono();		
		
  });
  GEvent.addDomListener(maoDiv, "mouseover", function() {
  		
  });
  
  GEvent.addDomListener(maoDiv, "mouseout", function() {  		
  		
  });    
  map.getContainer().appendChild(container);
  return container;
}


ComandoMaoSelecionado.prototype.getDefaultPosition = function() {
  return new GControlPosition(G_ANCHOR_TOP_LEFT, new GSize(80,7));
}


ComandoMaoSelecionado.prototype.setButtonStyle_ = function(button) {
  //button.style.textDecoration = "underline";
 // button.style.color = "#0000cc";
  //button.style.backgroundColor = "white";
  //button.style.font = "small Arial";
  //button.style.border = "1px solid black";
  //button.style.padding = "2px";
  //button.style.marginBottom = "3px";
  //button.style.textAlign = "center";
  button.style.width = "7.42em";
  button.style.height = "2.68em";
  button.style.cursor = "pointer";
  button.style.backgroundImage = "url('./images/comandoMaoSel_"+localeWikiCrimes+".png')";
}


//Comando dentro do mapa para marcar uma area
function ComandoMarcadorDeAreaSelecionado() {
}
ComandoMarcadorDeAreaSelecionado.prototype = new GControl();

ComandoMarcadorDeAreaSelecionado.prototype.initialize = function(map) {
  var container = document.createElement("div");

  var marcarAreaDiv = document.createElement("div");
  this.setButtonStyle_(marcarAreaDiv);
  container.appendChild(marcarAreaDiv);
  marcarAreaDiv.appendChild(document.createTextNode(""));
  GEvent.addDomListener(marcarAreaDiv, "click", function() {
    //startShape();
  });
  GEvent.addDomListener(marcarAreaDiv, "mouseover", function() {
  		mostraHintComandosMapa("webapp.area.erro.info.hint.area", "138px", "268px");
  });
  
  GEvent.addDomListener(marcarAreaDiv, "mouseout", function() {  		
  		removeHintComandosMapa();
  });    

  map.getContainer().appendChild(container);
  return container;
}


ComandoMarcadorDeAreaSelecionado.prototype.getDefaultPosition = function() {
  return new GControlPosition(G_ANCHOR_TOP_LEFT, new GSize(170,7));
}


ComandoMarcadorDeAreaSelecionado.prototype.setButtonStyle_ = function(button) {
  //button.style.textDecoration = "underline";
 // button.style.color = "#0000cc";
  //button.style.backgroundColor = "white";
  //button.style.font = "small Arial";
  //button.style.border = "1px solid black";
  //button.style.padding = "2px";
  //button.style.marginBottom = "3px";
  //button.style.textAlign = "center";
  button.style.width = "7.42em";
  button.style.height = "2.68em";
  button.style.cursor = "pointer";
  button.style.backgroundImage = "url('./images/comandoAreaSel_"+localeWikiCrimes+".png')";
}


//Comando dentro do mapa para gerarEmbed
function ComandoEmbed() {
}
ComandoEmbed.prototype = new GControl();

ComandoEmbed.prototype.initialize = function(map) {
  var container = document.createElement("div");

  var embedDiv = document.createElement("div");
  this.setButtonStyle_(embedDiv);
  container.appendChild(embedDiv);
  embedDiv.appendChild(document.createTextNode(textoEmbedMapaWikiCrimes));
  GEvent.addDomListener(embedDiv, "click", function() {
	 gerarEmbedded(); 
     selecionarComando(map, 'mao');
  });
  GEvent.addDomListener(embedDiv, "mouseover", function() {
  
  });
  
  GEvent.addDomListener(embedDiv, "mouseout", function() {  		
  
  });    

  map.getContainer().appendChild(container);
  return container;
}


ComandoEmbed.prototype.getDefaultPosition = function() {
  return new GControlPosition(G_ANCHOR_TOP_RIGHT, new GSize(6,28));
}


ComandoEmbed.prototype.setButtonStyle_ = function(button) {
  button.style.textDecoration = "underline";
  //button.style.color = "#0000cc";
  button.style.backgroundColor = "white";
  button.style.border = "1px solid black";
  button.style.padding = "2px";
  button.style.marginBottom = "3px";
  button.style.textAlign = "center";
 
  button.style.cursor = "pointer";
  //button.style.backgroundImage = "url('./images/comandoEmbed.png')";
}

function ComandoKernel() {
}
ComandoKernel.prototype = new GControl();

ComandoKernel.prototype.initialize = function(map) {
  var container = document.createElement("div");

  var kernelDiv = document.createElement("div");
  this.setButtonStyle_(kernelDiv);
  container.appendChild(kernelDiv);
  kernelDiv.appendChild(document.createTextNode(""));
  GEvent.addDomListener(kernelDiv, "click", function() {
//*********************** Kernel Map INICIO ****************************
//clique no botao pra ativar o mapa de kernel
	  kernelModifiedByUser = true;
	  ativaMapaKernel();
//*********************** Kernel Map FIM ****************************
  });
  
  GEvent.addDomListener(kernelDiv, "mouseover", function() {
	  mostraHintComandosMapa("tutor.ajuda.hots.spots", "138px", "268px");
  });
  
  GEvent.addDomListener(kernelDiv, "mouseout", function() {  		
	  removeHintComandosMapa();
  });
     
  map.getContainer().appendChild(container);
  return container;
}


ComandoKernel.prototype.getDefaultPosition = function() {
  return new GControlPosition(G_ANCHOR_TOP_LEFT, new GSize(170,40));
}


ComandoKernel.prototype.setButtonStyle_ = function(button) {
  //button.style.textDecoration = "underline";
 // button.style.color = "#0000cc";
  //button.style.backgroundColor = "white";
  //button.style.font = "small Arial";
  //button.style.border = "1px solid black";
  //button.style.padding = "2px";
  //button.style.marginBottom = "3px";
  //button.style.textAlign = "center";
  button.style.width = "7.42em";
  button.style.height = "2.68em";
  button.style.cursor = "pointer";
  button.style.backgroundImage = "url('./images/comandoKernel_"+localeWikiCrimes+".png')";
}

function ComandoKernelSelecionado() {
}
ComandoKernelSelecionado.prototype = new GControl();

ComandoKernelSelecionado.prototype.initialize = function(map) {
  var container = document.createElement("div");

  var kernelDiv = document.createElement("div");
  this.setButtonStyle_(kernelDiv);
  container.appendChild(kernelDiv);
  kernelDiv.appendChild(document.createTextNode(""));
  GEvent.addDomListener(kernelDiv, "click", function() {  	
//*********************** Kernel Map INICIO ****************************
//clique no botao pra desativar o mapa de kernel
	if(map.getZoom() >= zoomLimiteSupKernel){
		kernelModifiedByUser = true;
		desativaMapaKernel();  
	}
//*********************** Kernel Map FIM ****************************
  });
  GEvent.addDomListener(kernelDiv, "mouseover", function() {
	  mostraHintComandosMapa("tutor.ajuda.hots.spots", "138px", "268px");
  });
  
  GEvent.addDomListener(kernelDiv, "mouseout", function() {  		
	  removeHintComandosMapa();
  });    
  map.getContainer().appendChild(container);
  return container;
}


ComandoKernelSelecionado.prototype.getDefaultPosition = function() {
  return new GControlPosition(G_ANCHOR_TOP_LEFT, new GSize(170,40));
}

ComandoKernelSelecionado.prototype.setButtonStyle_ = function(button) {
	  //button.style.textDecoration = "underline";
	 // button.style.color = "#0000cc";
	  //button.style.backgroundColor = "white";
	  //button.style.font = "small Arial";
	  //button.style.border = "1px solid black";
	  //button.style.padding = "2px";
	  //button.style.marginBottom = "3px";
	  //button.style.textAlign = "center";
	  button.style.width = "7.42em";
	  button.style.height = "2.68em";
	  button.style.cursor = "pointer";
	  button.style.backgroundImage = "url('./images/comandoKernelSel_"+localeWikiCrimes+".png')";
}