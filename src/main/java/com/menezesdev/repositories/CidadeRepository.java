package com.menezesdev.repositories;

import com.menezesdev.models.Categoria;
import com.menezesdev.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Serializable> {

}
