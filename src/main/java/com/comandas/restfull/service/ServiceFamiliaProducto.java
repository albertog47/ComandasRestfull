package com.comandas.restfull.service;

import java.util.List;
import java.util.Optional;

import com.comandas.restfull.entity.FamiliaProducto;


public interface ServiceFamiliaProducto {
	
	
	public List<FamiliaProducto> findAllFamiliaProductos();	
	public Optional<FamiliaProducto> findFamiliaProductoById(Integer id);	
	public FamiliaProducto saveFamiliaProducto(FamiliaProducto familiaProducto);	
	public void deleteFamiliaProducto(Integer id);	
	public FamiliaProducto updateFamiliaProducto(FamiliaProducto familiaProducto);
	public List<FamiliaProducto> findFamiliaProductoByidTipo(Integer id);

}
