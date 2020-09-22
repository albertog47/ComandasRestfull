package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandas.restfull.entity.FamiliaProducto;
import com.comandas.restfull.exception.ModelNontFoundException;
import com.comandas.restfull.repository.RepositoryFamiliaProducto;

@Service
public class ServiceFamiliaProductoImple implements ServiceFamiliaProducto {

	@Autowired
	RepositoryFamiliaProducto repositoryFamiliaProducto;

	@Override
	public List<FamiliaProducto> findAllFamiliaProductos() {

		return repositoryFamiliaProducto.findAll();
	}

	@Override
	public Optional<FamiliaProducto> findFamiliaProductoById(Integer id) {
		Optional<FamiliaProducto> familiaProducto = repositoryFamiliaProducto.findById(id);
		if (familiaProducto.isEmpty()) {
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
		return repositoryFamiliaProducto.save(familiaProducto);
	}

}
