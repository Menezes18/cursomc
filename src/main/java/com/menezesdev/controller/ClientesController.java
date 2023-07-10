package com.menezesdev.controller;

import com.menezesdev.models.Categoria;
import com.menezesdev.models.Cliente;
import com.menezesdev.services.CategoriaService;
import com.menezesdev.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/clientes")
public class ClientesController {

	@Autowired
	private ClienteService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente cliente = service.find(id);
		return ResponseEntity.ok().body(cliente);
	}



}
