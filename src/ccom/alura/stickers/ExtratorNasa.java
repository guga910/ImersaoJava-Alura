package ccom.alura.stickers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorNasa implements ExtratorDeConteudo {

	@Override
	public List<Conteudo> extratorDeConteudo(String json) {
		JsonParser parse = new JsonParser();
		List<Map<String, String>> jsonPront = parse.parse(json);
		List<Conteudo> conteudo = new ArrayList<Conteudo>();

		for (Map<String, String> item : jsonPront) {
			String image = item.get("hdurl");
			String title = item.get("title");
			Conteudo conteudo2 = new Conteudo(image, title);
			conteudo.add(conteudo2);
		}
		return conteudo;
	}

}
