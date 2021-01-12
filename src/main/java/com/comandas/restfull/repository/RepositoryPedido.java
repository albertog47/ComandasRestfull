package com.comandas.restfull.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.comandas.restfull.entity.Pedido;


@Repository
public interface RepositoryPedido  extends JpaRepository<Pedido, Long>{
	
}
