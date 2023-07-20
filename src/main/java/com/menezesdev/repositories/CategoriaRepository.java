package com.menezesdev.repositories;

import com.menezesdev.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
