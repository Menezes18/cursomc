package com.menezesdev.repositories;

import com.menezesdev.models.Cliente;
import com.menezesdev.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Serializable> {

}
