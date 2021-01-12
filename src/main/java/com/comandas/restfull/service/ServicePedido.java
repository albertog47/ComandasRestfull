package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;


import com.comandas.restfull.entity.Pedido;


public interface ServicePedido {

	public List<Pedido> findAllPedidos();	
	public Optional<Pedido> findPedidoById(Long id);	
	public Pedido savePedido(Pedido pedido);	
	public void deletePedido(Long id);	
	public Pedido updatePedido(Pedido pedido);
	

}
