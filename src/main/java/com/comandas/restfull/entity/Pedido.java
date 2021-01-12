package com.comandas.restfull.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Pedidos")
public class Pedido  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6190168215085687730L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private String nombre;
	
	@Column
	private int cantidadProductos;
	
	@Column
	private  double importe;

	public Pedido(String nombre, int cantidadProductos, double importe) {
		
		this.nombre = nombre;
		this.cantidadProductos = cantidadProductos;
		this.importe = importe;
	}

	public Pedido() {
	
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

	public int getCantidadProductos() {
		return cantidadProductos;
	}

	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	

	@OneToMany(mappedBy = "pedido")
	private List<LineasPedido> LineasPedido;
}
