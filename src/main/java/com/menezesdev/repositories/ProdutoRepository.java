package com.menezesdev.repositories;


import com.menezesdev.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Serializable> {

}
