package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import com.comandas.restfull.entity.LineaPedido;
import com.comandas.restfull.entity.Pedido;
import com.comandas.restfull.entity.PedidoVo;


public interface ServicePedido {

	public List<Pedido> findAllPedidos();	
	public Optional<Pedido> findPedidoById(Long id);
	public Optional<Pedido>  savePedido(PedidoVo pedido);	
	public void deletePedido(Long id);	
	public Pedido updatePedido(Pedido pedido);
	public Optional<List<Pedido>> findPedidoByNombre(String nombre);
	

}
