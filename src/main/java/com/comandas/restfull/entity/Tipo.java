package com.comandas.restfull.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



@Entity(name="tipos")
public class Tipo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8253933975142997341L;

	@Id
	@Column (name="id_tipo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column 
	private String nombre;
	

	public Tipo() {
	
	}

	
	public Tipo(String nombre) {
		
		this.nombre = nombre;
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
	

	@OneToMany(mappedBy = "tipo")
	private List<FamiliaProducto> familiaProducto;



/*
	public List<FamiliaProducto> getFamiliaProducto() {
		return familiaProducto;
	}


	public void setFamiliaProducto(List<FamiliaProducto> familiaProducto) {
		this.familiaProducto = familiaProducto;
	}

*/


}
