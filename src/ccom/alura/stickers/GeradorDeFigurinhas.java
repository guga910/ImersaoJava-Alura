package ccom.alura.stickers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

	// leitura da imagem

	public void criar(InputStream inputStream, String nomeArquivo) throws Exception {

		BufferedImage imagemOriginal = ImageIO.read(inputStream);

		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;

		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		// criar uma nova imagem com transparencia e com tamanho novo:
		Graphics2D grafics = (Graphics2D) novaImagem.getGraphics();
		grafics.drawImage(imagemOriginal, 0, 0, null);
		// copiar a imagem original para a nova imagem(em memoria)

		// Configurar Uma fonte:
		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32);
		grafics.setColor(Color.YELLOW);
		grafics.setFont(fonte);

		String textoFigurinha = "Agora foi!";
		int centrado = 0;

		// escrever uma frase na nova imagem
		grafics.drawString(textoFigurinha, centrado, novaAltura - 100);

		// escrever uma nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));

	}

}
