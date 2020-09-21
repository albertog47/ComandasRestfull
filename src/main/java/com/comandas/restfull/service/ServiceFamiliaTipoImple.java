package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandas.restfull.entity.FamiliaTipo;
import com.comandas.restfull.repository.RepositoryFamiliaTipo;

@Service
public class ServiceFamiliaTipoImple implements ServiceFamiliaTipo {

	@Autowired
	RepositoryFamiliaTipo repoFamiliaTipo;
	
	@Override
	public List<FamiliaTipo> findAllFamiliaTipos() {

		return repoFamiliaTipo.findAll();
	}

	@Override
	public Optional<FamiliaTipo> findFamiliaTipoById(Integer id) {
		Optional<FamiliaTipo> familiaTipo = repoFamiliaTipo.findById(id);	
		return familiaTipo;
	}

	@Override
	public FamiliaTipo saveFamiliaTipo(FamiliaTipo familiaTipo) {
		// TODO Auto-generated method stub
		return repoFamiliaTipo.save(familiaTipo);
	}

	@Override
	public String deleteFamiliaTipo(Integer id) {
		if (repoFamiliaTipo.findById(id).isPresent()) {		
			repoFamiliaTipo.deleteById(id);				
			return "Familia eliminada correctamente.";			}	
		return "Error! La familia no existe";
	}

	@Override
	public FamiliaTipo updateFamiliaTipo(FamiliaTipo familiaTipo) {
		return repoFamiliaTipo.save(familiaTipo);
	}

}
