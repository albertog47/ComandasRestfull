package com.comandas.restfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.comandas.restfull.entity.FamiliaTipo;
import com.comandas.restfull.service.ServiceFamiliaTipo;

@RestController
public class FamiliaTipoController {

	@Autowired
	ServiceFamiliaTipo serviceFamiliaTipo;

	// http://localhost:9120/familias (GET)
	@RequestMapping(value = "/familias", method = RequestMethod.GET, produces = "application/json")
	public List<FamiliaTipo> getFamilias() {

		return serviceFamiliaTipo.findAllFamiliaTipos();
	}

	@RequestMapping(value = "/familias/{id}", method = RequestMethod.GET, produces = "application/json")	
	public Optional<FamiliaTipo> getFamiliaTipoById(@PathVariable Integer id) {		
		return serviceFamiliaTipo.findFamiliaTipoById(id);
		}
	@RequestMapping(value = "/familias/add", method = RequestMethod.POST, produces = "application/json")
	public FamiliaTipo addFamilia(@RequestBody FamiliaTipo familiaTipo) {
		return serviceFamiliaTipo.saveFamiliaTipo(familiaTipo);
	}
	
	@RequestMapping(value = "/familias/update", method = RequestMethod.PUT, produces = "application/json")
	public FamiliaTipo updateFamilia(@RequestBody FamiliaTipo familiaTipo) {
		return serviceFamiliaTipo.saveFamiliaTipo(familiaTipo);
	}
	
	@RequestMapping(value = "/familias/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteFamilia(@PathVariable("id") Integer id) {
		return serviceFamiliaTipo.deleteFamiliaTipo(id);
	}
}
