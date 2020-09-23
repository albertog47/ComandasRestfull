package com.comandas.restfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comandas.restfull.entity.Producto;
import com.comandas.restfull.service.ServiceProducto;


@RestController
@RequestMapping("/familias/fampro/producto")
public class ProductoController {

	@Autowired
	ServiceProducto serviceProducto;

	// http://localhost:9120/familias/fampro/producto" (GET)
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity <List<Producto>> getProductos() {

		return new ResponseEntity <>(serviceProducto.findAllProductos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Producto>> getProductoById(@PathVariable Long id) {
		
		return new  ResponseEntity<>(serviceProducto.findProductoById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Producto> addProducto(@RequestBody Producto Producto) {
		
		return new ResponseEntity <>(serviceProducto.saveProducto(Producto), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Object>  updateProducto(@RequestBody Producto Producto) {
		serviceProducto.saveProducto(Producto);
		return new ResponseEntity <>( HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public  ResponseEntity<Object>  deleteProducto(@PathVariable("id") Long id) {
		
		serviceProducto.deleteProducto(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
}
