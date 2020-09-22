package com.comandas.restfull.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="familias_tipos")
public class FamiliaTipo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8253933975142997341L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	
	@Column 
	private String nombre;
	
	
	

	public FamiliaTipo() {
	
	}

	
	public FamiliaTipo(String nombre) {
		
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
	
	
	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name="id_familia")
	private List<FamiliaProducto> familiaProductos;




	public List<FamiliaProducto> getFamiliaProductos() {
		return familiaProductos;
	}


	public void setFamiliaProductos(List<FamiliaProducto> familiaProductos) {
		this.familiaProductos = familiaProductos;
	}

}
