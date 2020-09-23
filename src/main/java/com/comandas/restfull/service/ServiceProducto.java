package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import com.comandas.restfull.entity.Producto;

public interface ServiceProducto {

	public List<Producto> findAllProductos();	
	public Optional<Producto> findProductoById(Long id);	
	public Producto saveProducto(Producto producto);	
	public void deleteProducto(Long id);	
	public Producto updateProducto(Producto producto);
	
}
