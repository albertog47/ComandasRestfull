package com.comandas.restfull.entity;

import java.io.Serializable;
import java.util.Calendar;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Column
	private String comentarios;
	@Column
	private String tipo_envio;
	
	@Column
	private String direccion;
	
	@Column
	private int telefono;
	
	@Column
	private String estado;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar  fecha;




	public Pedido(String nombre, int cantidadProductos, double importe, String comentarios, String tipo_envio,
			String direccion, int telefono, Calendar fecha) {
		super();
		this.nombre = nombre;
		this.cantidadProductos = cantidadProductos;
		this.importe = importe;
		this.comentarios = comentarios;
		this.tipo_envio = tipo_envio;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fecha = fecha;
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
	

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Calendar  getFecha() {
		return fecha;
	}

	public void setFecha(Calendar  fecha) {
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



	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	@OneToMany(mappedBy = "pedido")
	private List<LineaPedido> LineaPedido;
}
