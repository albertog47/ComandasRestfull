package com.comandas.restfull.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.comandas.restfull.entity.Pedido;



@Repository
public interface RepositoryPedido  extends JpaRepository<Pedido, Long>{
	
	 @Query("select p FROM Pedido p  where p.nombre = ?1  ORDER BY id DESC")
	Optional<List<Pedido>> findByNombre(String nombre);
	 
	 @Query("select p FROM Pedido p ORDER BY id DESC")
	 public Optional<List<Pedido>> findAllPedidosDesc();	
	 
	
	 
		

}
