package com.mitocode.repo;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Consulta;


public interface IConsultaRepo extends IGenericRepo<Consulta, Integer> {
	
	@Query("FROM Consulta c WHERE c.paciente.dni= :dni OR LOWER (c.paciente.nombres) LIKE %:nombreCompleto% OR LOWER (c.paciente.apellidos) LIKE %:nombreCompleto%")
	List<Consulta> buscar(@Param("dni") String dni,@Param("nombreCompleto") String nombreCompeto);
	
	
	@Query("FROM Consulta c WHERE c.fecha BETWEEN :fechaConsulta AND :fechaSgte")
	List<Consulta> buscarFecha(@Param("fechaConsulta") LocalDateTime fechaConsulta,@Param("fechaSgte") LocalDateTime fechaSgte);

}
