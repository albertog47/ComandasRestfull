package com.comandas.restfull.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandas.restfull.entity.Estado;
import com.comandas.restfull.repository.RepositoryEstado;
import com.comandas.restfull.security.enums.EstadosNombre;

@Service
public class ServiceEstadoImple implements ServiceEstado {

	@Autowired
	RepositoryEstado repoEstado;
	@Override
	public Estado saveEstado(Estado estado) {
		// TODO Auto-generated method stub
		 Estado esta=repoEstado.save(estado);
		return esta;
	}

	@Override
	public Optional<Estado> findEstadoByEstadonombre(EstadosNombre estado_nombre) {
		 Optional<Estado> est= repoEstado.findByEstadoNombre(estado_nombre);
		return null;
	}

	

}
