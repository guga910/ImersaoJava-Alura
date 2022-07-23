package ccom.alura.stickers;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
	

	public void criarImdb(String url, String textoFigurinha) {
		ClienteHttp cliente = new ClienteHttp();
		String body = cliente.conexao(url);
		
		ExtratorImdb ec = new ExtratorImdb();
		List<Conteudo> lista = ec.extratorDeConteudo(body);
		
		GeradorDeFigurinhas gdf = new GeradorDeFigurinhas();

		for (int i = 0; i < lista.size(); i++) {
//			String imagem = lista.get(i).getImage();
//			String title = "My - " + lista.get(i).getTitle() + ".png";
			String imagem = lista.get(i).image();
			
			String title = "My - " + lista.get(i).title() + ".png";
			System.out.println(title);
			System.out.println(imagem);
			try {
				InputStream ips;
				ips = new URL(imagem).openStream();
				gdf.criar(ips, title, textoFigurinha);			
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
		}
	}
	public void criarNasa(String url, String textoFigurinha)  {
		ClienteHttp cliente = new ClienteHttp();
		String body = cliente.conexao(url);
		
		ExtratorNasa ec = new ExtratorNasa();
		List<Conteudo> lista = ec.extratorDeConteudo(body);
		
		GeradorDeFigurinhas gdf = new GeradorDeFigurinhas();
		
		for (int i = 0; i < lista.size(); i++) {
//			String imagem = lista.get(i).getImage();
//			String title = "My - " + lista.get(i).getTitle() + ".png";
			String imagem = lista.get(i).image();
			String title = "My - " + lista.get(i).title() + ".png";
			System.out.println(title);
			System.out.println(imagem);
			
			// Url da imagem
			InputStream ips;
			
			
			try {
				ips = new URL(imagem).openStream();
				gdf.criar(ips, title, textoFigurinha);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
