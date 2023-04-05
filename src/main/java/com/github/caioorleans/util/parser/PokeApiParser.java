package com.github.caioorleans.util.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.caioorleans.excepions.JsonParsingException;
import com.github.caioorleans.model.ImageInfo;

@Component
public class PokeApiParser implements IParser{
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public ImageInfo parse(String json) {
		var info = new ImageInfo();
		try {
			JsonNode rootNode = objectMapper.readTree(json);
			info.setTitle(rootNode.path("name").asText());
			info.setUrlImage(rootNode
					.path("sprites")
					.path("other")
					.path("home")
					.path("front_default")
					.asText());
			if(info.getTitle().isBlank() || info.getUrlImage().isBlank()) {
				throw new JsonParsingException();
			}
			return info;
		} catch (JsonProcessingException e) {
			throw new JsonParsingException();
		}
	}

}
