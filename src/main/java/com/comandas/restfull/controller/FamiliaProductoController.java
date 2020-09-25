package com.comandas.restfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comandas.restfull.entity.FamiliaProducto;
import com.comandas.restfull.service.ServiceFamiliaProducto;


@RestController
@RequestMapping("/tipo/fampro")
public class FamiliaProductoController {

	@Autowired
	ServiceFamiliaProducto serviceFamiliaProducto;

	// http://localhost:9120/familias/fampro/ (GET)
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity <List<FamiliaProducto>> getFamilias() {

		return new ResponseEntity <>(serviceFamiliaProducto.findAllFamiliaProductos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<FamiliaProducto>> getFamiliaProductoById(@PathVariable Integer id) {
		
		return new  ResponseEntity<>(serviceFamiliaProducto.findFamiliaProductoById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<FamiliaProducto> addFamilia(@RequestBody FamiliaProducto familiaProducto) {
		
		return new ResponseEntity <>(serviceFamiliaProducto.saveFamiliaProducto(familiaProducto), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Object>  updateFamilia(@RequestBody FamiliaProducto familiaProducto) {
		serviceFamiliaProducto.updateFamiliaProducto(familiaProducto);
		return new ResponseEntity <>( HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public  ResponseEntity<Object>  deleteFamilia(@PathVariable("id") Integer id) {
		
		serviceFamiliaProducto.deleteFamiliaProducto(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
}
