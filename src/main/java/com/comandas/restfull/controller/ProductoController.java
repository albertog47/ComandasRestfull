package com.comandas.restfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comandas.restfull.entity.FamiliaProducto;
import com.comandas.restfull.entity.Producto;
import com.comandas.restfull.exception.ModelNontFoundException;
import com.comandas.restfull.service.ServiceProducto;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tipo/fampro/producto")
public class ProductoController {

	@Autowired
	ServiceProducto serviceProducto;

	// http://localhost:9120/tipo/fampro/producto" (GET)
	@RequestMapping(value = "/consult", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity <List<Producto>> getProductos() {

		return new ResponseEntity <>(serviceProducto.findAllProductos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/consult/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Producto>> getProductoById(@PathVariable Long id) {
		
		return new  ResponseEntity<>(serviceProducto.findProductoById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Producto> addProducto(@RequestBody Producto producto) {
		
		return new ResponseEntity <>(serviceProducto.saveProducto(producto), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Object>  updateProducto(@RequestBody Producto producto) {
		serviceProducto.updateProducto(producto);
		 return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public  ResponseEntity<Object>  deleteProducto(@PathVariable("id") Long id) {
		
		serviceProducto.deleteProducto(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/consult/idfamilia/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Producto>> getProductoByIdFamilia(@PathVariable Integer id) {
		
		return new  ResponseEntity<>(serviceProducto.findProductoByidFamilia(id), HttpStatus.OK);
	}
}
