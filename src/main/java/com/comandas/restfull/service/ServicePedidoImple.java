package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.comandas.restfull.entity.Pedido;
import com.comandas.restfull.exception.ModelNontFoundException;
import com.comandas.restfull.repository.RepositoryPedido;

@Service
public class ServicePedidoImple implements ServicePedido {

	@Autowired
	RepositoryPedido repositoryPedido;
	
	
	@Override
	public List<Pedido> findAllPedidos() {
		return repositoryPedido.findAll();
	}

	@Override
	public Optional<Pedido> findPedidoById(Long id) {
		Optional<Pedido> pedido = repositoryPedido.findById(id);
		if (!pedido.isPresent()) {
			throw new ModelNontFoundException("Error! El pedido no ha sido encontrado");
		} else {
			return pedido;
		}
	}

	@Override
	public Pedido savePedido(Pedido pedido) {
		
		return repositoryPedido.save(pedido);
	}

	@Override
	public void deletePedido(Long id) {
		if (repositoryPedido.findById(id).isPresent()) {
			repositoryPedido.deleteById(id);

		} else {

			throw new ModelNontFoundException("Error! El Pedido no existe");
		}

		
	}

	@Override
	public Pedido updatePedido(Pedido pedido) {
		if (repositoryPedido.findById(pedido.getId()).isPresent()) {
			return repositoryPedido.save(pedido);
		} else {

			throw new ModelNontFoundException("Error! El pedido no existe");
		}
	}

	

}
