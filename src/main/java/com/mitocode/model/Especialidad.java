package com.mitocode.model;

import javax.persistence.*;


@Entity
@Table(name="especialidad")
public class Especialidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidad;
	
	@Column(name="nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name="descripcion", nullable = false, length = 50)
	private String descripcion;

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombres() {
		return nombre;
	}

	public void setNombres(String nombres) {
		this.nombre = nombres;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
