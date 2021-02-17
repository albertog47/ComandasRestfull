package com.comandas.restfull.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comandas.restfull.entity.LineaPedido;
import com.comandas.restfull.entity.Pedido;


@Repository
public interface RepositoryLineasPedido  extends JpaRepository<LineaPedido, Long>{
	List<LineaPedido> findByPedido(Optional<Pedido> pedido);
	
	
}
