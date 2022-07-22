package ccom.alura.stickers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class CodigoDoProfessor {
	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		// leitura da imagem
		// InputStream inputStream =
		// new FileInputStream(new File("entrada/filme-maior.jpg"));
		// InputStream inputStream =
		// new
		// URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
		// .openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);

		// cria nova imagem em memória com transparência e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		// copiar a imagem original pra novo imagem (em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);

		// configurar a fonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(fonte);

		// escrever uma frase na nova imagem
		graphics.drawString("TOPZERA", 100, novaAltura - 100);

		// escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));

	}

	public static void main(String[] args) throws Exception {

		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		String body = response.body();
		System.out.println(body);

		// extrair só os dados que interessam (titulo, poster, classificação)
		var parser = new JsonParser();
		
		List<Map<String, String>> listaDeFilmes = parser.parse(body); // lista de livros List
//		listaDeFilmes.get(5).get("title");
		// exibir e manipular os dados
		var geradora = new CodigoDoProfessor();
		
	       for (Map<String,String> filme : listaDeFilmes) {

	            String urlImagem = filme.get("image");
	            String titulo = filme.get("title");

	            InputStream inputStream = new URL(urlImagem).openStream();
	            String nomeArquivo = titulo + ".png";

	            geradora.cria(inputStream, nomeArquivo);

	            System.out.println(titulo);
	            System.out.println();
	        }
//		String url2 = "https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg";
//		InputStream ips= new URL(url2).openStream();
//		String texto= "temquedacerto.png";
//		geradora.cria(ips, texto);
//		System.out.println("ve se deu cetto...");
//		System.out.println(listaDeFilmes.get(5).get("title"));
	}
}
