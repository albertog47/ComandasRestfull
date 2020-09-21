package com.comandas.restfull.entity;

import javax.persistence.*;




@Entity
@Table(name="familias_productos")
public class FamiliaProducto {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column 
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="id_familia")
	private FamiliaTipo familiaTipo;
	
	
	
	

}
