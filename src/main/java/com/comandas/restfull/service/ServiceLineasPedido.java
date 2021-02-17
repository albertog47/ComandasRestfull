package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import com.comandas.restfull.entity.LineaPedido;




public interface ServiceLineasPedido {
	
	public List<LineaPedido> findAllLineasPedido();	
	public List<LineaPedido> findIdPedido(Long id);
	public Optional<LineaPedido> findLineasPedidoById(Long id);	
	public LineaPedido saveLineasPedido(LineaPedido lineasPedido);	
	public void deleteLineasPedido(Long id);	
	public LineaPedido updateLineasPedido(LineaPedido lineasPedido);
	

}
