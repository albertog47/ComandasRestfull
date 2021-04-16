package com.comandas.restfull.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comandas.restfull.entity.Estado;

import com.comandas.restfull.security.enums.EstadosNombre;


@Repository
public interface RepositoryEstado extends JpaRepository<Estado,Integer>{
	   Optional<Estado> findByEstadoNombre(EstadosNombre estadoNombre);
}
