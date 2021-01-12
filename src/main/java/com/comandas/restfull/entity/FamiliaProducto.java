package com.comandas.restfull.entity;

import java.io.Serializable;


import javax.persistence.*;


@Entity (name="familias_productos")

public class FamiliaProducto implements Serializable {
	

	private static final long serialVersionUID = -3045648238479324502L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column 
	private String nombre;
	

	
	@ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo", nullable = false)
    private Tipo tipo;
	
	
	
	public FamiliaProducto() {
	}



	public FamiliaProducto(String nombre, Tipo familiaTipo) {
		this.nombre = nombre;
		this.tipo = familiaTipo;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	/*	@OneToMany(mappedBy = "familiaProducto")
	private List<Producto> productos;

	public List<Producto> getProductos() {
		return productos;
	}




	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	*/

	
	
	

}
