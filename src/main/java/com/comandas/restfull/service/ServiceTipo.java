package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;



import com.comandas.restfull.entity.Tipo;


public interface ServiceTipo {
	
	
	public List<Tipo> findAllTipos();	
	public Optional<Tipo> findTipoById(Integer id);	
	public Tipo saveTipo(Tipo tipo);	
	public void deleteTipo(Integer id);	
	public Tipo updateTipo(Tipo tipo);
	

}
