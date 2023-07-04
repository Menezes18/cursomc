package com.menezesdev.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaResourcce {
	
	
	@RequestMapping(method=RequestMethod.GET) //obter um dado 
	public String listar()
	{
		return "Rest esta funcionando!";
	}

}
