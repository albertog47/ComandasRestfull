package com.comandas.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comandas.restfull.entity.FamiliaProducto;

@Repository
public interface RepositoryFamiliaProducto extends JpaRepository<FamiliaProducto ,Integer> {

}
