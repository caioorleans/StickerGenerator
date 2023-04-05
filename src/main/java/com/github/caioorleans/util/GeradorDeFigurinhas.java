package com.github.caioorleans.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import com.github.caioorleans.excepions.StickerNotGeneratedException;

@Component
public class GeradorDeFigurinhas {

	public String criar(InputStream inputStream, String nomeArquivo, String text){

		try {
			BufferedImage imagemOriginal = ImageIO.read(inputStream);
			int largura = imagemOriginal.getWidth();
			int altura = imagemOriginal.getHeight();

			int novaAltura = altura + 200;

			var novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

			Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
			graphics.drawImage(imagemOriginal, null, 0, 0);

			var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32);
			graphics.setFont(fonte);

			if(text == null) {
				text = "Imagem top";
			}
			graphics.setColor(Color.BLACK);
			FontMetrics fm = graphics.getFontMetrics();
			graphics.drawString(text, (largura - fm.stringWidth(text))/2, novaAltura - 100);

			String caminho = "/com/github/caioorleans/images" +nomeArquivo + ".png";
			
			var novoArquivo = new File("target/classes"+caminho);
			novoArquivo.mkdirs();
			ImageIO.write(novaImagem, "png", novoArquivo);
			
			return caminho;
		} catch (IOException e) {
			throw new StickerNotGeneratedException();
		}

		
	}
}
