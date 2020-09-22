package com.comandas.restfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comandas.restfull.entity.FamiliaTipo;
import com.comandas.restfull.service.ServiceFamiliaTipo;

@RestController
public class FamiliaTipoController {

	@Autowired
	ServiceFamiliaTipo serviceFamiliaTipo;

	// http://localhost:9120/familias (GET)
	@RequestMapping(value = "/familias", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity <List<FamiliaTipo>> getFamilias() {

		return new ResponseEntity <>(serviceFamiliaTipo.findAllFamiliaTipos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/familias/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<FamiliaTipo>> getFamiliaTipoById(@PathVariable Integer id) {
		
		return new  ResponseEntity<>(serviceFamiliaTipo.findFamiliaTipoById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/familias/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<FamiliaTipo> addFamilia(@RequestBody FamiliaTipo familiaTipo) {
		
		return new ResponseEntity <>(serviceFamiliaTipo.saveFamiliaTipo(familiaTipo), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/familias/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Object>  updateFamilia(@RequestBody FamiliaTipo familiaTipo) {
		serviceFamiliaTipo.saveFamiliaTipo(familiaTipo);
		return new ResponseEntity <>( HttpStatus.OK);
	}

	@RequestMapping(value = "/familias/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public  ResponseEntity<Object>  deleteFamilia(@PathVariable("id") Integer id) {
		
		serviceFamiliaTipo.deleteFamiliaTipo(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
}
