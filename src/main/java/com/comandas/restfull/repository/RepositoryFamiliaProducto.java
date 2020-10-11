package com.comandas.restfull.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comandas.restfull.entity.FamiliaProducto;
import com.comandas.restfull.entity.Producto;
import com.comandas.restfull.entity.Tipo;

@Repository
public interface RepositoryFamiliaProducto extends JpaRepository<FamiliaProducto ,Integer> {

	public List<FamiliaProducto> findByTipo(Optional<Tipo> tipo);
}
