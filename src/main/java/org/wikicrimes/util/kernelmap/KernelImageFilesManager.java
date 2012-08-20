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
package org.wikicrimes.util.kernelmap;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import br.com.wikinova.heatmaps.KMRFactory;
import br.com.wikinova.heatmaps.KernelMap;
import br.com.wikinova.heatmaps.renderer.KernelMapRenderer;

/**
 * Nao eh mais usado.
 * 
 * Criacao e delecao de imagens relacionadas com Mapa de Kernel.
 * Obs: A implementacao do Mapa de Kernel gera imagens com um endereco similar a 
 * "/images/KernelMap/[id-da-sessao]/". Esta classe gerencia a criacao e delecao das imagens.
 * 
 * @author victor
 */
public class KernelImageFilesManager {

	private static final String PATH = "/images/KernelMap/"; 
	private static int num = 0; //numero q vai incrementando pra imagem, pra evitar cache
	
	
	/**
	 * Deleta o diretorio e imagens (de Mapa de Kernel) relacionados a uma unica sessao 
	 */
	public static void deletaImagem(HttpSession sessao){
		String imagePath = realImagePath(sessao);
		File dir = new File(imagePath);
		deletaArquivo(dir);
	}
	
	/**
	 * Deleta um diretorio qualquer contendo imagens PNG.
	 */
	private static void deletaArquivo(final File dir){
		//obs: a delecao eh agendade para alguns segundos mais tarde
		//pra corrigir um bug q acontecia ocasionalmente de a imagem ser deletada antes de ser exibida
		
		TimerTask task = 
			new TimerTask(){
			public void run() {
				
				File[] files = dir.listFiles();
				if(files != null){
					
					//encontra o arquivo com menor numero X "ImgX.png"
					File menorFile = null;
					int menor = Integer.MAX_VALUE;
					for(File file : files){
						String nome = file.getName();
						int num = Integer.valueOf( nome.substring(3, nome.length()-4) );
						if(num < menor){
							menor = num;
							menorFile = file;
						}
					}
					
					//deleta o arquivo (de menor numero)
					//if(menorFile.getName().endsWith(".png")) //seguranca, pra n deletar outras coisas 
					menorFile.delete();
				}
				
				//deleta o diretorio se tiver ficado vazio
				new Timer().schedule(deletaDir, 10000);
				
			}
			
			TimerTask deletaDir = 
				new TimerTask(){
				public void run() {
					//deleta so se tiver ficado vazio
					File[] files = dir.listFiles();
					if(files != null && files.length == 0)
						dir.delete();
				}
			};
		};
		
		new Timer().schedule(task, 10000);
	}

	
	public static String criarImagem(KernelMap kernel, HttpSession sessao){
		
		KernelMapRenderer renderer = KMRFactory.getDefaultRenderer(kernel);
		Image imagem = renderer.renderImage();
		
		String fileName = nomeImagem(sessao);
		String imagePath = realImagePath(sessao);
		try {
			new File(imagePath).mkdirs();
			ImageIO.write((RenderedImage)imagem, "PNG", new File(imagePath, fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return relativeImagePath(sessao) + fileName;
		
	}
	
	private synchronized static String nomeImagem(HttpSession sessao){
		String nome = "Img" + num + ".png";
		num++;
		return nome;
	}
	
	private static String realImagePath(HttpSession sessao){
		String imagePath = sessao.getServletContext().getRealPath(relativeImagePath(sessao));
		return imagePath + "/";
	}
	
	private static String relativeImagePath(HttpSession sessao){
		return PATH + sessao.getId() + "/";
	}
	
}
