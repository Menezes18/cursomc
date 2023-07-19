package com.menezesdev.repositories;

import com.menezesdev.models.Categoria;
import com.menezesdev.models.Help;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface HelpRepository extends JpaRepository<Help, Serializable> {
    Help findByComando(String comando);

}
