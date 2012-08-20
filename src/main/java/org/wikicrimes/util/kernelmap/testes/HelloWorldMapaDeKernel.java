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
package org.wikicrimes.util.kernelmap.testes;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import br.com.wikinova.heatmaps.KernelMap;
import br.com.wikinova.heatmaps.renderer.KernelMapRenderer;
import br.com.wikinova.heatmaps.renderer.TransparentToColorKMR;

public class HelloWorldMapaDeKernel {

	public static void main(String[] args) throws IOException {
		
		//criar bounds
		Rectangle bounds = new Rectangle(0,0,50,50);
		
		//criar lista de pontos
		List<Point> pontos = new ArrayList<Point>();
		Point p = new Point(0,1);
		pontos.add(p);
		p = new Point(1,1);
		pontos.add(p);
		p = new Point(1,1);
		pontos.add(p);	
		
		//criar objeto KernelMap (so tem a grid de doubles)
		KernelMap km = new KernelMap(bounds,pontos);
		
		//gerar a imagem
		KernelMapRenderer kmr = new TransparentToColorKMR(km,Color.RED);
		RenderedImage image = (RenderedImage) kmr.renderImage();
		
		//salvar imagem em arquivo
		ImageIO.write(image, "png", new File("/home/victor/teste.png"));
		
	}
	
}
