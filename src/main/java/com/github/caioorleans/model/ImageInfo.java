package com.github.caioorleans.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("image_info")
public class ImageInfo {

	@Id
	private String keyWord;
	private String title;
	private String urlImage;
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String pokemonName) {
		this.title = pokemonName;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	
}
