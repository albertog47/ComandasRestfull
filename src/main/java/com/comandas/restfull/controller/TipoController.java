package com.comandas.restfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comandas.restfull.entity.Tipo;
import com.comandas.restfull.service.ServiceTipo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tipos")
public class TipoController {

	@Autowired
	ServiceTipo serviceTipo;

	// http://localhost:9120/tipos (GET)
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity <List<Tipo>> getTipo() {

		return new ResponseEntity <>(serviceTipo.findAllTipos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Tipo>> getTipoById(@PathVariable Integer id) {
		
		return new  ResponseEntity<>(serviceTipo.findTipoById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Tipo> addTipo(@RequestBody Tipo tipo) {
		
		return new ResponseEntity <>(serviceTipo.saveTipo(tipo), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Object>  updateTipo(@RequestBody Tipo tipo) {
		serviceTipo.updateTipo(tipo);
		return new ResponseEntity <>( HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public  ResponseEntity<Object>  deleteTipo(@PathVariable("id") Integer id) {
		
		serviceTipo.deleteTipo(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
}
