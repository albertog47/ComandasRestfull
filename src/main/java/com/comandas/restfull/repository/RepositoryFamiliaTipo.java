package com.comandas.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comandas.restfull.entity.FamiliaTipo;

@Repository
public interface RepositoryFamiliaTipo extends JpaRepository<FamiliaTipo ,Integer> {

}
