package com.comandas.restfull.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Productos")
public class Producto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1556530529924055656L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private String nombre;
	
	@Column
	private int cantidad;
	
	@Column
	private  double precio;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_familia_producto", nullable = false)
    private FamiliaProducto familiaProducto;

	
	public Producto( String nombre, int cantidad, double precio, FamiliaProducto familiaProducto) {
		
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.familiaProducto = familiaProducto;
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

	public FamiliaProducto getFamiliaProducto() {
		return familiaProducto;
	}

	public void setFamiliaProducto(FamiliaProducto familiaProducto) {
		this.familiaProducto = familiaProducto;
	}

	

	

	
	
	

}
