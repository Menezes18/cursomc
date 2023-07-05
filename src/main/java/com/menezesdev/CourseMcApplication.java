package com.menezesdev;

import com.menezesdev.models.Categoria;
import com.menezesdev.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class CourseMcApplication implements CommandLineRunner { //CommandLineRunner - cria o metodo auxiliar
	@Autowired
	private CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(CourseMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	Categoria cat1 = new Categoria(3, "Informática");
		//Categoria cat2 = new Categoria(4, "Escritório");

		//categoriaRepository.saveAll(Arrays.asList(cat1, cat2));


	}
}
