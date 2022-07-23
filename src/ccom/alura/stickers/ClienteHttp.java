package ccom.alura.stickers;

import static java.net.URI.create;
import static java.net.http.HttpClient.newHttpClient;
import static java.net.http.HttpRequest.newBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
	
	
	public String conexao(String url)  {
		URI endereco= create(url);
		HttpClient client = newHttpClient();
		HttpRequest solicitar= newBuilder(endereco).GET().build();
		HttpResponse<String> resposta;
		try {
			resposta = client.send(solicitar, BodyHandlers.ofString());
		String body= resposta.body();
		System.out.println(resposta.statusCode());
		System.out.println(body);
		return body;
		
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
		}
		return null;
		
		
	}
	
	
//
//
//	// Extrair dados JSON :
//	JsonParser parse = new JsonParser();
//
//	List<Map<String, String>> listaDeConteudo = parse.parse(body);

}
