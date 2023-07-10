package com.menezesdev.repositories;

import com.menezesdev.models.Pagamento;
import com.menezesdev.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Serializable> {

}
