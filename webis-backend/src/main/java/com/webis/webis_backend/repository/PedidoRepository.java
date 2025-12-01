package com.webis.webis_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.webis.webis_backend.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}