package com.mitocode.model;

import javax.persistence.*;

@Entity
@Table(name="detalle_consulta")
public class DetalleConsulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalle;
	
	@ManyToOne
	@JoinColumn(name= "id_consulta",nullable= false, foreignKey= @ForeignKey(name= "FK_consulta_detalle"))
	private Consulta consulta;
	
    @Column(name = "diagnostico", length= 70, nullable =true)	
	private String diagnostico;
    
    @Column(name = "tratamiento", length= 300, nullable =true)	
	private String tratamiento;

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

}
