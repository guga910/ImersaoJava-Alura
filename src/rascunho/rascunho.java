package rascunho;

import ccom.alura.stickers.App;

public class rascunho {

	public static void main(String[] args) throws Exception {

		App app=	new App();
//		String urlImdb = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
//		app.criarImdb(urlImdb, "Testando!");
		
		String urlNasa= "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
		app.criarNasa(urlNasa, "Testando, NASA! de novo");

			System.out.println("e ai, fez algo de bom?");
		
	}

}
