package com.comandas.restfull.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.comandas.restfull.security.enums.EstadosNombre;

@Entity(name="Estado")
	
public class Estado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EstadosNombre estadoNombre;
	
	

	public Estado(@NotNull EstadosNombre estadoNombre) {
		
		this.estadoNombre = estadoNombre;
	}

	public Estado() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadosNombre getEstadoNombre() {
		return estadoNombre;
	}

	public void setEstadoNombre(EstadosNombre estadoNombre) {
		this.estadoNombre = estadoNombre;
	}

	
	
	
	
}
