package com.comandas.restfull.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Productos")
public class Producto implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private String nombre;
	
	@Column
	private int cantidad;
	
	@Column
	private  double precio;
	
	@Column
	private Integer id_familia_producto;

	

	public Producto( String nombre, int cantidad, double precio, Integer id_familia_producto) {
		
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.id_familia_producto = id_familia_producto;
	}

	public Producto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Integer getId_familia_producto() {
		return id_familia_producto;
	}

	public void setId_familia_producto(Integer id_familia_producto) {
		this.id_familia_producto = id_familia_producto;
	}


	
	

}
