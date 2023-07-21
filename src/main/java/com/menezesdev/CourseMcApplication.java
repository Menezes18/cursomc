package com.menezesdev;

import com.menezesdev.models.*;
import com.menezesdev.models.enums.EstadoPagamento;
import com.menezesdev.models.enums.TipoCliente;
import com.menezesdev.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CourseMcApplication implements CommandLineRunner { //CommandLineRunner - cria o metodo auxiliar
	public static void main(String[] args) {
		SpringApplication.run(CourseMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
