package rascunho;

import ccom.alura.stickers.App;

public class rascunho {

	public static void main(String[] args) throws Exception {

		App app=	new App();
		String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
		app.criarImdb(url, "Testando!");

			System.out.println("e ai, fez algo de bom?");
		
	}

}
