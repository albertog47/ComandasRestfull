package com.comandas.restfull.entity;

import java.io.Serializable;

import javax.persistence.*;




@Entity
@Table(name="familias_productos")
public class FamiliaProducto implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3045648238479324502L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column 
	private String nombre;
	
	/*@ManyToOne
	@JoinColumn(name="id_familia")
	private FamiliaTipo familiaTipo;
*/
	
	@Column
	private Integer id_familia;
	
	public FamiliaProducto() {
	}


	

	public FamiliaProducto(String nombre, Integer id_familia) {
		this.nombre = nombre;
		this.id_familia = id_familia;
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




	public Integer getId_familia() {
		return id_familia;
	}




	public void setId_familia(Integer id_familia) {
		this.id_familia = id_familia;
	}

	

	
	
	

}
