package com.menezesdev.controller;

import com.menezesdev.dto.CategoriaDTO;
import com.menezesdev.models.Categoria;
import com.menezesdev.services.CategoriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria categoria = service.find(id);
		return ResponseEntity.ok().body(categoria);
	}
		//return ResponseEntity.badRequest().body(new Error(1, "Error processing request"));
		//return ResponseEntity<>(obj, HttpStatus.OK);


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria categoria) {
		categoria = service.insert(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Integer id){
		categoria.setId(id);
		categoria = service.update(categoria);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Categoria categoria, @PathVariable Integer id) {
		categoria.setId(id);
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDto = list.stream().map(objcategoria -> new CategoriaDTO(objcategoria)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(

			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderby", defaultValue = "nome")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {

		Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> listDto = list.map(objcategoria -> new CategoriaDTO(objcategoria));
		return ResponseEntity.ok().body(listDto);
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
