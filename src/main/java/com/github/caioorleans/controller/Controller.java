package com.github.caioorleans.controller;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.caioorleans.service.PokeFigurinhaService;

@RestController
@RequestMapping(("api/"))
public class Controller {
	
	@Autowired
	private PokeFigurinhaService pokeService;
	
	@GetMapping("favorite-pokemon/{name}")
	@ResponseBody
	public ResponseEntity<InputStreamResource> get(@PathVariable("name") String name){
		
		InputStream input = pokeService.buscarFigurinha(name);
		
		return ResponseEntity.ok()
			      .contentType(MediaType.IMAGE_PNG)
			      .body(new InputStreamResource(input));
	}
}
