package com.mitocode.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class ConsultaExamenPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="id_consulta", nullable=false)
	private Consulta consulta;
	
	@ManyToOne
	@JoinColumn(name="id_examen", nullable=false)
	private Examen examen;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + ((examen == null) ? 0 : examen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaExamenPK other = (ConsultaExamenPK) obj;
		if (consulta == null) {
			if (other.consulta != null)
				return false;
		} else if (!consulta.equals(other.consulta))
			return false;
		if (examen == null) {
			if (other.examen != null)
				return false;
		} else if (!examen.equals(other.examen))
			return false;
		return true;
	}
	




	//los debo referencias en las clases equals y hashCode para que no
	//queden como todo en el objeto si no que devuelva el valor unico,  de lo contrario generario un advertencia
// com.mitocode.model.Consulta@dadasdas   || 1
// com.mitocode.model.Examne@dadasdas     || 5 
	
	

}
