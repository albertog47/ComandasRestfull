package com.comandas.restfull.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.comandas.restfull.entity.Tipo;

@Repository
public interface RepositoryTipo extends JpaRepository<Tipo ,Integer> {
		
}
