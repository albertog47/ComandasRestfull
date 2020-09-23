package com.comandas.restfull.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.comandas.restfull.entity.Producto;
@Repository
public interface RepositoryProducto extends JpaRepository<Producto, Long>{

}
