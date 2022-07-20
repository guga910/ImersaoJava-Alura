package ccom.alura.stickers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

	// leitura da imagem

	public void criar(InputStream inputStream, String nomeArquivo) throws Exception {
//		https://github.com/alura-cursos/imersao-java/blob/aula2/alura-stickers/src/GeradoraDeFigurinhas.java

//		String url = "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,3,128,176_AL_.jpg\r\n";
//		InputStream ipsUrl = new URL(url).openStream();
//		classe que presenta uma fonte de bytes com isso, posso receber e transformar no tipo de arquivo desejado

//		File arquivo = new File("entrada/sda.jpg");

//		InputStream ips2= new FileInputStream(new File("entrada/sda.jpg"));

		BufferedImage imagemOriginal = ImageIO.read(inputStream);

		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura - 50;
		int novaLargura = largura + 100;

		BufferedImage novaImagem = new BufferedImage(novaAltura, novaLargura, BufferedImage.TYPE_BYTE_INDEXED);

		// criar uma nova imagem com transparencia e com tamanho novo:
		Graphics2D grafics = (Graphics2D) novaImagem.getGraphics();
		grafics.drawImage(imagemOriginal, 0, 0, null); // para escrever uma imagem nova em cima da imagem antiga, usei o
														// metodo drawImage

		// copiar a imagem original para a nova imagem(em memoria)

		// Configurar Uma fonte:
		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32);
		grafics.setColor(Color.YELLOW);
		grafics.setFont(fonte);

		// escrever uma frase na nova imagem
		grafics.drawString("TOPT10", 0, novaLargura - 20);

		// escrever uma nova imagem em um arquivo
		ImageIO.write(novaImagem, "jpg", new File("saida/"+nomeArquivo));

	}
	public static void main(String[] args) throws Exception {
		
		String texto= "texto.jpg";
		String url = "https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg";
		InputStream ipsUrl = new URL(url).openStream();
		
		new GeradorDeFigurinhas().criar(ipsUrl, texto);
		System.out.println("ve ai se foi...");
		
	}

}
