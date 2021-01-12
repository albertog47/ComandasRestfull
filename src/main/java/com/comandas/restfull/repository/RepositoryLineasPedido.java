package com.comandas.restfull.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comandas.restfull.entity.LineasPedido;
import com.comandas.restfull.entity.Pedido;


@Repository
public interface RepositoryLineasPedido  extends JpaRepository<LineasPedido, Long>{
	List<LineasPedido> findByPedido(Optional<Pedido> pedido);
	
}
