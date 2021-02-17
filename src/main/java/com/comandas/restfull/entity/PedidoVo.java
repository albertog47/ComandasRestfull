package com.comandas.restfull.entity;

import java.io.Serializable;
import java.util.List;



public class PedidoVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2746748998771343420L;


	private Long id;

	private String nombre;
	
	private int cantidadProductos;
	
	private  double importe;
	
	private List<LineaPedido> lineasPedido;

	
	
	

	public PedidoVo(String nombre, int cantidadProductos, double importe, List<LineaPedido> lineasPedido) {
		super();
		this.nombre = nombre;
		this.cantidadProductos = cantidadProductos;
		this.importe = importe;
		this.lineasPedido = lineasPedido;
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

	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	
}
