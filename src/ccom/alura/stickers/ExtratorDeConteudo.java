package ccom.alura.stickers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudo {
	
	public List<Conteudo> imdb(String json) {
		JsonParser parse= new JsonParser();
		List<Map<String, String>> jsonPront = parse.parse(json);
		
		List<Conteudo> conteudo= new ArrayList<>();
		
		for(Map<String, String> item : jsonPront) {
//			int indice= 0;
//			conteudo.get(indice).setTitle(item.get("title"));
//			conteudo.get(indice).setImage(item.get("image"));
//			indice++;
			String image= item.get("image");
			String title= item.get("title");
			Conteudo conteudo2 = new Conteudo(image,title);
			conteudo.add(conteudo2);
		}
		return conteudo;
	}
	public List<Conteudo> nasa(String json) {
		JsonParser parse= new JsonParser();
		List<Map<String, String>> jsonPront = parse.parse(json);
		List<Conteudo> conteudo= new ArrayList<Conteudo>();
		for(Map<String, String> item : jsonPront) {
			int indice= 0;
			
			conteudo.get(indice).setTitle(item.get("title"));
			conteudo.get(indice).setImage(item.get("url"));
			indice++;
		}
		return conteudo;
	}

}
