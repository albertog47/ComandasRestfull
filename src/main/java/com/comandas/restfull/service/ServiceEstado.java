package com.comandas.restfull.service;

import java.util.Optional;

import com.comandas.restfull.entity.Estado;
import com.comandas.restfull.security.enums.EstadosNombre;


public interface ServiceEstado  {
	public Estado saveEstado(Estado estado);	
	public Optional<Estado>findEstadoByEstadonombre(EstadosNombre estado_nombre);
}
