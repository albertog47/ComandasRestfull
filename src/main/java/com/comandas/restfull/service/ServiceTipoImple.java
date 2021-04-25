package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.comandas.restfull.entity.Tipo;
import com.comandas.restfull.exception.ModelNontFoundException;
import com.comandas.restfull.repository.RepositoryTipo;

@Service
public class ServiceTipoImple implements ServiceTipo {

	@Autowired
	RepositoryTipo repoFamiliaTipo;
	
	@Override
	public List<Tipo> findAllTipos() {

		return repoFamiliaTipo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	

	@Override
	public Optional<Tipo> findTipoById(Integer id) {
		Optional<Tipo> familiaTipo = repoFamiliaTipo.findById(id);	
		if (!familiaTipo.isPresent()){
			throw new ModelNontFoundException( "Error! La familia no ha sido encontrada");
		}else {
		return familiaTipo;
		}
	}

	@Override
	public Tipo saveTipo(Tipo tipo) {
		// TODO Auto-generated method stub
		return repoFamiliaTipo.save(tipo);
	}

	@Override
	public void deleteTipo(Integer id) {
		if (repoFamiliaTipo.findById(id).isPresent()) {		
			repoFamiliaTipo.deleteById(id);				
			}	else {
		throw new ModelNontFoundException( "Error! La familia no existe");
			}
	}

	@Override
	public Tipo updateTipo(Tipo tipo) {
		if (repoFamiliaTipo.findById(tipo.getId()).isPresent()) {	
		return repoFamiliaTipo.save(tipo);
		}else {
			throw new ModelNontFoundException( "Error! La familia no existe");
				}
	}




}
