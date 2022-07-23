package ccom.alura.stickers;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
	

	public void criarImdb(String url, String textoFigurinha) throws Exception {
		ClienteHttp cliente = new ClienteHttp();
		String body = cliente.conexao(url);
		
		ExtratorDeConteudo ec = new ExtratorDeConteudo();
		List<Conteudo> lista = ec.imdb(body);
		
		GeradorDeFigurinhas gdf = new GeradorDeFigurinhas();

		for (int i = 0; i < lista.size(); i++) {
			String imagem = lista.get(i).getImage();
			String title = "My - " + lista.get(i).getTitle() + ".png";
			System.out.println(title);
			System.out.println(imagem);
			InputStream ips= new URL(imagem).openStream();;
			
				ips = new URL(imagem).openStream();
				gdf.criar(ips, title, textoFigurinha);			
		}
	}
}
