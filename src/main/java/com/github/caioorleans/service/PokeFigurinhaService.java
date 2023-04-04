package com.github.caioorleans.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.caioorleans.excepions.ConnectionInterruptedException;
import com.github.caioorleans.model.ImageInfo;
import com.github.caioorleans.util.ClientHttp;
import com.github.caioorleans.util.GeradorDeFigurinhas;
import com.github.caioorleans.util.parser.PokeApiParser;

@Service
public class PokeFigurinhaService implements FigurinhaService{
	
	@Autowired
	private ClientHttp client;
	
	@Autowired
	private GeradorDeFigurinhas gerador;
	
	@Autowired
	private PokeApiParser pokeParser;
	
	private static final String URL_API = "https://pokeapi.co/api/v2/pokemon/";

	@Override
	public InputStream gerarFigurinha(String complementoUrl) {
		
		try {
			String urlRequest = URL_API + complementoUrl;
			
			ImageInfo info = pokeParser.parse(client.buscaDados(urlRequest));
			
			InputStream inputStream = new URL(info.getUrlImage()).openStream();
			
			String urlImagem = gerador.criar(inputStream, info.getTitle(), "Esse é meu pokemon favorito!");
			
			return getClass().getResourceAsStream(urlImagem);
		}
		catch(IOException ex) {
			throw new ConnectionInterruptedException();
		}
		
	}

}
