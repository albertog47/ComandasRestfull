package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandas.restfull.entity.FamiliaProducto;
import com.comandas.restfull.entity.Producto;
import com.comandas.restfull.entity.Tipo;
import com.comandas.restfull.exception.ModelNontFoundException;
import com.comandas.restfull.repository.RepositoryFamiliaProducto;
import com.comandas.restfull.repository.RepositoryTipo;

@Service
public class ServiceFamiliaProductoImple implements ServiceFamiliaProducto {

	@Autowired
	RepositoryFamiliaProducto repositoryFamiliaProducto;
	@Autowired
	RepositoryTipo repositoryTipo;
	@Override
	public List<FamiliaProducto> findAllFamiliaProductos() {

		return repositoryFamiliaProducto.findAll();
	}

	@Override
	public Optional<FamiliaProducto> findFamiliaProductoById(Integer id) {
		Optional<FamiliaProducto> familiaProducto = repositoryFamiliaProducto.findById(id);
		if (!familiaProducto.isPresent()) {
			throw new ModelNontFoundException("Error! La familia producto no ha sido encontrada");
		} else {
			return familiaProducto;
		}
	}

	@Override
	public FamiliaProducto saveFamiliaProducto(FamiliaProducto familiaProducto) {

		return repositoryFamiliaProducto.save(familiaProducto);
	}

	@Override
	public void deleteFamiliaProducto(Integer id) {
		if (repositoryFamiliaProducto.findById(id).isPresent()) {
			repositoryFamiliaProducto.deleteById(id);

		} else {

			throw new ModelNontFoundException("Error! La familia producto no existe");
		}
	}

	@Override
	public FamiliaProducto updateFamiliaProducto(FamiliaProducto familiaProducto) {
		if (repositoryFamiliaProducto.findById(familiaProducto.getId()).isPresent()) {
		return repositoryFamiliaProducto.save(familiaProducto);
		} else {

			throw new ModelNontFoundException("Error! La familia producto no existe");
		}
	}

	@Override
	public List<FamiliaProducto> findFamiliaProductoByidTipo(Integer id) {
		Optional<Tipo> tipo=repositoryTipo.findById(id);
		List<FamiliaProducto> familiaProducto=repositoryFamiliaProducto.findByTipo(tipo);
		if(familiaProducto.isEmpty()) {
			throw new ModelNontFoundException("Error! La familia producto no ha sido encontrado");
		}else{
			return familiaProducto;
		}
	
		
		
	}

}
