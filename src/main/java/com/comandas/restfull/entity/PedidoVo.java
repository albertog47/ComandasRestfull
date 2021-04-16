package com.comandas.restfull.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;



public class PedidoVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2746748998771343420L;


	private Long id;

	private String nombre;
	
	private int cantidadProductos;
	
	private  double importe;

	private String comentarios;
	
	private String tipo_envio;
	
	private String direccion;
	
	private int telefono;
		
	private List<LineaPedido> lineasPedido;

	private Calendar  fecha;



	public PedidoVo(String nombre, int cantidadProductos, double importe, String comentarios, String tipo_envio,
			String direccion, int telefono, List<LineaPedido> lineasPedido, Calendar fecha) {
	
		this.nombre = nombre;
		this.cantidadProductos = cantidadProductos;
		this.importe = importe;
		this.comentarios = comentarios;
		this.tipo_envio = tipo_envio;
		this.direccion = direccion;
		this.telefono = telefono;
		this.lineasPedido = lineasPedido;
		this.fecha = fecha;
		
		
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

	
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getTipo_envio() {
		return tipo_envio;
	}

	public void setTipo_envio(String tipo_envio) {
		this.tipo_envio = tipo_envio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	

	
	
}
