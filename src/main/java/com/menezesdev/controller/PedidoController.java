package com.menezesdev.controller;

import com.menezesdev.dto.CategoriaDTO;
import com.menezesdev.models.Categoria;
import com.menezesdev.models.Cliente;
import com.menezesdev.models.Pedido;
import com.menezesdev.services.ClienteService;
import com.menezesdev.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value ="/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido Pedido = service.find(id);
		return ResponseEntity.ok().body(Pedido);
	}


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido pedido) {
		pedido = service.insert(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
}
