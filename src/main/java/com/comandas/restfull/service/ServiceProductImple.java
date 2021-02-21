package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandas.restfull.entity.FamiliaProducto;
import com.comandas.restfull.entity.Producto;
import com.comandas.restfull.exception.ModelNontFoundException;
import com.comandas.restfull.repository.RepositoryFamiliaProducto;
import com.comandas.restfull.repository.RepositoryProducto;

@Service
public class ServiceProductImple implements ServiceProducto {
	@Autowired
	RepositoryProducto repositoryProducto;
	@Autowired
	RepositoryFamiliaProducto repositoryfamiliaProducto;

	@Override
	public List<Producto> findAllProductos() {

		return repositoryProducto.findAll();
	}

	@Override
	public Optional<Producto> findProductoById(Long id) {
		Optional<Producto> producto = repositoryProducto.findById(id);
		if (!producto.isPresent()) {
			throw new ModelNontFoundException("Error! El producto no ha sido encontrado");
		} else {
			return producto;
		}
	}

	@Override
	public Producto saveProducto(Producto producto) {

		return repositoryProducto.save(producto);
		
	}

	@Override
	public void deleteProducto(Long id) {
		if (repositoryProducto.findById(id).isPresent()) {
			repositoryProducto.deleteById(id);

		} else {

			throw new ModelNontFoundException("Error! El producto no existe");
		}

	}

	@Override
	public Producto updateProducto(Producto producto) {
		if (repositoryProducto.findById(producto.getId()).isPresent()) {
			return repositoryProducto.save(producto);
		} else {

			throw new ModelNontFoundException("Error! El producto no existe");
		}
	}


	public  List<Producto> findProductoByidFamilia(Integer id) {
		Optional<FamiliaProducto> familiaProducto=repositoryfamiliaProducto.findById(id);
		List<Producto> producto = repositoryProducto.findByFamiliaProducto(familiaProducto);
		if (producto.isEmpty()) {
			throw new ModelNontFoundException("Error! El producto no ha sido encontrado");
		} else {
			return producto;
		}
	}
	@Override
	public boolean validarProducto(Producto producto) {
		boolean validar=true;
		if(producto.getCantidad()>0) {
			validar=false;
		}
		else if(producto.getPrecio()>0) {
			validar=false;
		}
		else if(producto.getFamiliaProducto().getId()==null) {
			validar=false;
		}
		else if(producto.getFamiliaProducto().getTipo().getId()==null) {
			validar=false;
		}
		return validar;
	}

	
}
