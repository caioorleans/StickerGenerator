package com.github.caioorleans.service;

import java.io.InputStream;

public interface FigurinhaService {

	public String gerarFigurinha(String complementoUrl);
	
	public InputStream buscarFigurinha(String complementoUrl);
}
