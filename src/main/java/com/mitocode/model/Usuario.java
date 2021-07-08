package com.mitocode.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	private Integer idUsuario;
	
	@Column(name="nombre", nullable = false, unique= true)
	private String username;

	@Column(name="clave", nullable = false)
	private String password;
	
	@Column(name="estado", nullable = false)
	private String enabled;
	
	@ManyToMany(fetch= FetchType.EAGER)
	//Se realiza solo en la consulta que se de datoscortos ya que eager es vista de Halcon
	//y trae todo lo asociado a esa consulta y si es muchos datsopuedecolgar la base de datos
	//lazy viene generica y traducio es peresozo solo trae el dato especifico de una consulta
	//No esta creada se va a cerar tabla intermedia
	@JoinTable(name = "usuario_rol",
	      	joinColumns = @JoinColumn(name="id_usuario",referencedColumnName="idUsuario"),
	      	inverseJoinColumns = @JoinColumn(name="id_rol",referencedColumnName="idRol"))
	private List<Rol> roles;
	
	

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	

}
