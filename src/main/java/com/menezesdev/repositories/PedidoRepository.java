package com.menezesdev.repositories;

import com.menezesdev.models.Categoria;
import com.menezesdev.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Serializable> {

}
