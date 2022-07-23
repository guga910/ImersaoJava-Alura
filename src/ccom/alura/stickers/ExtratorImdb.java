package ccom.alura.stickers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorImdb implements ExtratorDeConteudo{

	@Override
	public List<Conteudo> extratorDeConteudo(String json) {
			JsonParser parse= new JsonParser();
			List< Map<String, String> > jsonPront = parse.parse(json);
			List<Conteudo> conteudos= new ArrayList<>();
			
			for(Map<String, String> item : jsonPront) {
				String image= item.get("image");
				String title= item.get("title");
				Conteudo conteudo2 = new Conteudo(image,title);
				conteudos.add(conteudo2);
			}
			return conteudos;
		}


}
