package com.comandas.restfull.repository;





import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.comandas.restfull.entity.Pedido;
import com.comandas.restfull.entity.PedidoVo;


@Repository
public interface RepositoryPedido  extends JpaRepository<Pedido, Long>{
	 @Query("FROM Pedido ORDER BY id DESC")
	Optional<List<Pedido>> findByNombre(String nombre);

}
