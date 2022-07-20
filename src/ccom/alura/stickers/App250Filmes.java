package ccom.alura.stickers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App250Filmes {
	public static void main(String[] args) throws IOException, InterruptedException {
//	https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpRequest.html
//	https://imdb-api.com/en/API/Top250TVs/k_i5x35d3q
//		String key = "k_i5x35d3q";
//		https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,3,128,176_AL_.jpg

		
		// Conexap HTTP:
		String url = "https://imdb-api.com/en/API/Top250Movies/k_i5x35d3q";
		URI endereco = URI.create(url);// endereco

		HttpClient client = HttpClient.newHttpClient();// cliente
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();// requisição/request

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		System.out.println(body);
		System.out.println("status da solicitação: " + response.statusCode());
		
		//Extrair dados JSON :
		JsonParser parse = new JsonParser();

		List<Map<String, String>> listaDeFilmes = parse.parse(body);
		
		// EXibir dados e Manipular:
		
		for(Map<String, String> item : listaDeFilmes) {
			System.out.println("Titulo: " + item.get("title"));
			System.out.println("Imagem: " + item.get("image"));
			System.out.println("Avaliação: " + item.get("imDbRating"));
			System.out.println();
		}

		System.out.println("e ai, fez algo de bom?");
	}

}
