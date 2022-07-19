package ccom.alura.stickers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class MaiorBilheteria {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// Conexao Http:
		
		String url = "https://imdb-api.com/en/API/BoxOffice/k_i5x35d3q";
		URI uri = URI.create(url);

		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		String body = response.body();
		System.out.println(response.body());
		System.out.println(response.statusCode());
		
		//Extrair dados JSON :
		JsonParser parse = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parse.parse(body);
		System.out.println("tamanho da lista: " + listaDeFilmes.size());
		
		for(Map<String, String> item: listaDeFilmes) {
			System.out.println("Titulo: "+item.get("title"));
//			System.out.println("Titulo: "+item.get("title"));
		}

	}

}
