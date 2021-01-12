package com.comandas.restfull.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandas.restfull.entity.LineasPedido;
import com.comandas.restfull.entity.Pedido;
import com.comandas.restfull.exception.ModelNontFoundException;
import com.comandas.restfull.repository.RepositoryLineasPedido;
import com.comandas.restfull.repository.RepositoryPedido;
import com.comandas.restfull.repository.RepositoryProducto;

@Service
public class ServiceLineasPedidoImple implements ServiceLineasPedido{

	@Autowired
	RepositoryLineasPedido repositoryLineasPedido;
	@Autowired
	RepositoryPedido repositoryPedido;
	@Autowired
	RepositoryProducto repositoryProducto;
	
	
	@Override
	public List<LineasPedido> findAllLineasPedido() {
		
		return repositoryLineasPedido.findAll();
	}

	@Override
	public Optional<LineasPedido> findLineasPedidoById(Long id) {
		Optional<LineasPedido> lineasPedido = repositoryLineasPedido.findById(id);
		if (!lineasPedido.isPresent()) {
			throw new ModelNontFoundException("Error! La línea de producto no ha sido encontrada");
		} else {
			return lineasPedido;
		}
	}

	@Override
	public LineasPedido saveLineasPedido(LineasPedido lineasPedido) {
		
		return repositoryLineasPedido.save(lineasPedido);
	}

	@Override
	public void deleteLineasPedido(Long id) {
		if (repositoryLineasPedido.findById(id).isPresent()) {
			repositoryLineasPedido.deleteById(id);

		} else {

			throw new ModelNontFoundException("Error! la línea no existe");
		}
		
	}

	@Override
	public LineasPedido updateLineasPedido(LineasPedido lineasPedido) {
		if (repositoryLineasPedido.findById(lineasPedido.getId()).isPresent()) {
			return repositoryLineasPedido.save(lineasPedido);
		} else {

			throw new ModelNontFoundException("Error! La línea de pedido no existe");
		}
	}



	@Override
	public List<LineasPedido> findIdPedido(Long id) {
		Optional<Pedido> pedido=repositoryPedido.findById(id);
		List<LineasPedido>lineasPedido=repositoryLineasPedido.findByPedido(pedido);
		if (!lineasPedido.isEmpty()) {
			throw new ModelNontFoundException("Error! No se han encontrado líneas de pedido");
		} else {
			return lineasPedido;
		}
	}

	

	
}
