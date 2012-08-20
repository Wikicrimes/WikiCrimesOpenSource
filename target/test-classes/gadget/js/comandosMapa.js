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

function ComandoAlerta() {
}
//ComandoAlerta.prototype = new GControl();

ComandoAlerta.prototype.initialize = function(map) {
  var container = document.createElement("div");

  var alertaDiv = document.createElement("div");
  this.setButtonStyle_(alertaDiv);
  container.appendChild(alertaDiv);
  alertaDiv.appendChild(document.createTextNode(""));
  GEvent.addDomListener(alertaDiv, "click", function() {
  	
  });
  
  GEvent.addDomListener(alertaDiv, "mouseover", function() {
  		
  });
  
  GEvent.addDomListener(alertaDiv, "mouseout", function() {  		
  		
  });
     
  map.getContainer().appendChild(container);
  return container;
}


ComandoAlerta.prototype.getDefaultPosition = function() {
  return new GControlPosition(G_ANCHOR_TOP_LEFT, new GSize(80,7));
}


ComandoAlerta.prototype.setButtonStyle_ = function(button) {
  //button.style.textDecoration = "underline";
 // button.style.color = "#0000cc";
  //button.style.backgroundColor = "white";
  //button.style.font = "small Arial";
  //button.style.border = "1px solid black";
  //button.style.padding = "2px";
  //button.style.marginBottom = "3px";
  //button.style.textAlign = "center";
  button.style.width = "2.52em";
  button.style.height = "2.52em";
  button.style.cursor = "pointer";
  button.style.backgroundImage = "url('./images/btns/pt/btnAlerta.PNG')";
}
