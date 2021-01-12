package com.comandas.restfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comandas.restfull.entity.LineasPedido;

import com.comandas.restfull.service.ServiceLineasPedido;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RequestMapping("/pedido/lineas")
public class LineasPedidoController {

	@Autowired
	ServiceLineasPedido serviceLineas;

	// http://localhost:9120/tipo/pedido/lineas" (GET)
	@RequestMapping(value = "/consult", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<LineasPedido>> getLineas() {

		return new ResponseEntity<>(serviceLineas.findAllLineasPedido(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/consult/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<LineasPedido>> getLineaById(@PathVariable Long id) {
		
		return new  ResponseEntity<>(serviceLineas.findLineasPedidoById(id), HttpStatus.OK);
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<LineasPedido> addLinea(@RequestBody LineasPedido lineasPedido) {
		
		return new ResponseEntity <>(serviceLineas.saveLineasPedido(lineasPedido), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Object>  updateLinea(@RequestBody LineasPedido lineasPedido) {
		serviceLineas.updateLineasPedido(lineasPedido);
		 return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public  ResponseEntity<Object>  deleteLineao(@PathVariable("id") Long id) {
		
		serviceLineas.deleteLineasPedido(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/consult/idPedido/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<LineasPedido>> getLineasByIdPedido(@PathVariable Long id) {
		
		return new  ResponseEntity<>(serviceLineas.findIdPedido(id), HttpStatus.OK);
	}
	
	

}
