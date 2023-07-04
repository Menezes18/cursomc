package com.menezesdev.controller;

import com.menezesdev.models.Categoria;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaController {



	@GetMapping(path = "/listar")
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");

		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);

		return lista;
	}
	@GetMapping(path = "/teste")
	public Categoria test() {
		return new Categoria(3, "Teste");
	}

	@PostMapping(path = "/testePost")
	public ResponseEntity<Categoria> testPost(@RequestBody Categoria cat){
		System.out.printf(cat.toString());
		return new ResponseEntity<>(cat, HttpStatus.OK);
	}

	@PostMapping(path = "/testPostList")
	public ResponseEntity<List<Categoria>> testPostList(@RequestBody List<Categoria> catList){
		for (int i = 0; i < catList.size(); i++){
		System.out.printf(catList.get(i).toString());
		}

		for (Categoria categoria: catList) {
			System.out.printf(categoria.toString());
		}

		return new ResponseEntity<>(catList, HttpStatus.OK);
	}



}
