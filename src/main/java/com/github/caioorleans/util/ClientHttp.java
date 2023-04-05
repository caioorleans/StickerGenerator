package com.github.caioorleans.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Component;

import com.github.caioorleans.excepions.ConnectionInterruptedException;
import com.github.caioorleans.excepions.NotFoundException;
import com.github.caioorleans.excepions.UnespectedErrorException;

@Component
public class ClientHttp {

	public String buscaDados(String url) {

		try {
			var endereco = URI.create(url);
			var client = HttpClient.newHttpClient();
			var request = HttpRequest.newBuilder(endereco).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			switch(response.statusCode()) {
				case 200:
					return response.body();
				case 404:
					throw new NotFoundException("Pokemon não encontrado");
				default:
					throw new UnespectedErrorException("API externa respondeu com erro inesperado");
			}
		} catch (IOException | InterruptedException ex) {
			throw new ConnectionInterruptedException();
		}

	}
}
