package ccom.alura.stickers;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

	// leitura da imagem

	public void criar() throws Exception {
		File arquivo = new File("entrada/sda.jpg");

//		InputStream ips = new FileInputStream(arquivo);

		BufferedImage imagemOriginal = ImageIO.read(arquivo);
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura-50 ;
		int novaLargura = largura +100;

		BufferedImage novaImagem = new BufferedImage(novaAltura, novaLargura, BufferedImage.TYPE_BYTE_INDEXED);

		// criar uma nova imagem com transparencia e com tamanho novo:
		Graphics2D grafics = (Graphics2D) novaImagem.getGraphics();
		grafics.drawImage(imagemOriginal, 0, 0, null); // para escrever uma imagem nova em cima da imagem antiga, usei o metodo drawImage 

		// copiar a imagem original para a nova imagem(em memoria)

		
		// Configurar Uma fonte:
		Font fonte= new Font(Font.SANS_SERIF,Font.BOLD, 32 );
		grafics.setColor(Color.YELLOW);
		grafics.setFont(fonte);

		// escrever uma frase na nova imagem
		grafics.drawString("TOPT10", 0, novaLargura-20);
		
		// escrever uma nova imagem em um arquivo
		ImageIO.write(novaImagem, "jpg", new File("saida/sda.jpg"));
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		var gerador= new GeradorDeFigurinhas();
		gerador.criar();
		
		System.out.println("saio??" );
		
	}
}
