package com.comandas.restfull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNontFoundException extends RuntimeException {

	/**
	 * 
	 */

	private static final long serialVersionUID = 3061701978984561071L;

	public ModelNontFoundException(String mensaje) {
		super(mensaje);

	}
}
