package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;



import com.comandas.restfull.entity.FamiliaTipo;


public interface ServiceFamiliaTipo {
	
	
	public List<FamiliaTipo> findAllFamiliaTipos();	
	public Optional<FamiliaTipo> findFamiliaTipoById(Integer id);	
	public FamiliaTipo saveFamiliaTipo(FamiliaTipo familiaTipo);	
	public String deleteFamiliaTipo(Integer id);	
	public FamiliaTipo updateFamiliaTipo(FamiliaTipo familiaTipo);
	

}
