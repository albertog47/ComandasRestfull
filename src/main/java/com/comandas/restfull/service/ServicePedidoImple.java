package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.comandas.restfull.entity.LineasPedido;
import com.comandas.restfull.entity.Pedido;
import com.comandas.restfull.entity.PedidoVo;
import com.comandas.restfull.exception.ModelNontFoundException;
import com.comandas.restfull.repository.RepositoryLineasPedido;
import com.comandas.restfull.repository.RepositoryPedido;

@Service
public class ServicePedidoImple implements ServicePedido {

	@Autowired
	RepositoryPedido repositoryPedido;
	@Autowired
	RepositoryLineasPedido repositoryLineasPedido;
	
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
	public Optional<Pedido>   savePedido(PedidoVo pedido) {
		//PedidoVo peRecibido= pedido;
		Pedido pe=new Pedido(pedido.getNombre(),pedido.getCantidadProductos(),pedido.getImporte());
		pe= repositoryPedido.save(pe);
		List<LineasPedido> lineas=pedido.getLineasPedido();
		for (LineasPedido ln: lineas) {
			ln.setPedido(pe);
			repositoryLineasPedido.save(ln);
		}
		
		
		 
		return repositoryPedido.findById(pe.getId());
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
