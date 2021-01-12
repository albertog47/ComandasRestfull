package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import com.comandas.restfull.entity.LineasPedido;




public interface ServiceLineasPedido {
	
	public List<LineasPedido> findAllLineasPedido();	
	public List<LineasPedido> findIdPedido(Long id);
	public Optional<LineasPedido> findLineasPedidoById(Long id);	
	public LineasPedido saveLineasPedido(LineasPedido lineasPedido);	
	public void deleteLineasPedido(Long id);	
	public LineasPedido updateLineasPedido(LineasPedido lineasPedido);
	

}
