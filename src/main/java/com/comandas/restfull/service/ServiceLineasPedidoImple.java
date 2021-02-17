package com.comandas.restfull.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandas.restfull.entity.LineaPedido;
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
	public List<LineaPedido> findAllLineasPedido() {
		
		return repositoryLineasPedido.findAll();
	}

	@Override
	public Optional<LineaPedido> findLineasPedidoById(Long id) {
		Optional<LineaPedido> lineasPedido = repositoryLineasPedido.findById(id);
		if (!lineasPedido.isPresent()) {
			throw new ModelNontFoundException("Error! La línea de producto no ha sido encontrada");
		} else {
			return lineasPedido;
		}
	}

	@Override
	public LineaPedido saveLineasPedido(LineaPedido lineasPedido) {
		
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
	public LineaPedido updateLineasPedido(LineaPedido lineasPedido) {
		if (repositoryLineasPedido.findById(lineasPedido.getId()).isPresent()) {
			return repositoryLineasPedido.save(lineasPedido);
		} else {

			throw new ModelNontFoundException("Error! La línea de pedido no existe");
		}
	}



	@Override
	public List<LineaPedido> findIdPedido(Long id) {
		Optional<Pedido> pedido=repositoryPedido.findById(id);
		List<LineaPedido>lineasPedido=repositoryLineasPedido.findByPedido(pedido);
		if (!lineasPedido.isEmpty()) {
			return lineasPedido;
		} else {
		
			throw new ModelNontFoundException("Error! No se han encontrado líneas de pedido");
		}
	}

	

	
}
