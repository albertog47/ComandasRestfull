package com.comandas.restfull.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comandas.restfull.entity.FamiliaProducto;
import com.comandas.restfull.entity.Producto;
@Repository
public interface RepositoryProducto extends JpaRepository<Producto, Long>{

	public List<Producto> findByFamiliaProducto(Optional<FamiliaProducto> familiaProducto);
}
