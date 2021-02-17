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

import com.comandas.restfull.entity.LineaPedido;
import com.comandas.restfull.entity.Pedido;
import com.comandas.restfull.entity.PedidoVo;
import com.comandas.restfull.service.ServiceLineasPedido;
import com.comandas.restfull.service.ServicePedido;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","*"})
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	ServicePedido servicioPedido;
	@Autowired
	ServiceLineasPedido serviceLineas;
	
	// http://localhost:9120/pedido" (GET)
		@RequestMapping(value = "/consult", method = RequestMethod.GET, produces = "application/json")
		public ResponseEntity <List<Pedido>> getPedidos() {

			return new ResponseEntity <>(servicioPedido.findAllPedidos(), HttpStatus.OK);
		}

		@RequestMapping(value = "/consult/{id}", method = RequestMethod.GET, produces = "application/json")
		public ResponseEntity<List<LineaPedido>> getPedidoById(@PathVariable Long id) {
			
			//return new  ResponseEntity<>(servicioPedido.findPedidoById(id), HttpStatus.OK);
			return new  ResponseEntity<>(serviceLineas.findIdPedido(id), HttpStatus.OK);
		}

		@RequestMapping(value = "/{nombre}", method = RequestMethod.GET, produces = "application/json")
		public ResponseEntity<Optional<List<Pedido>>> getPedidoByNombre(@PathVariable String nombre) {
			
			return new  ResponseEntity<>(servicioPedido.findPedidoByNombre(nombre), HttpStatus.OK);
		}

		@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
		public ResponseEntity<Optional<Pedido>>  addPedido(@RequestBody PedidoVo pedido) {
			
			return new ResponseEntity <>(servicioPedido.savePedido(pedido), HttpStatus.CREATED);
			
		}

		@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
		public ResponseEntity<Object>  updatePedido(@RequestBody Pedido pedido) {
			servicioPedido.updatePedido(pedido);
			 return new ResponseEntity<>(HttpStatus.OK);
		}

		@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
		public  ResponseEntity<Object>  deletePedido(@PathVariable("id") Long id) {
			
			servicioPedido.deletePedido(id);
			 return new ResponseEntity<>(HttpStatus.OK);
		}
		
		
	}

