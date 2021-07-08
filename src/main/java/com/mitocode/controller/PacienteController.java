package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService service;
    
	
	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Paciente>> listar() throws Exception{
		List<Paciente> lista=service.listar();
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
	}
	
//	@GetMapping("/test")
//	public Paciente test(){
//		Paciente pac =new Paciente();
//		pac.setIdPaciente(1);
//		pac.setNombres("Jaime");		
//		return pac;
//	}
	
	@GetMapping("/hateoas/{id}")
	public ResponseEntity<Paciente> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
		Paciente obj=service.listarPorId(id);
		
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		
		//localhost:8080/paciente/{id}
		EntityModel<Paciente> recurso=EntityModel.of(obj);
		//WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarPorId(id));
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Paciente obj=service.listarPorId(id);
		
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
	}
	
	//@RequestBody json a objeto  java
	@PostMapping
//	public Paciente registrar(@Valid @RequestBody Paciente paciente) {
//		return service.registrar(paciente);
//	}
	public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente paciente) throws Exception{
		Paciente obj=service.registrar(paciente);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPaciente()).toUri();
		
		return new ResponseEntity<Paciente>(obj, HttpStatus.CREATED);
	}
	
	
	@PutMapping
//	public Paciente modificar(@Valid @RequestBody Paciente paciente) {
//		return service.modificar(paciente);		
//	}
	public ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente paciente) throws Exception{
		Paciente obj=service.modificar(paciente);
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
//	public void eliminar (@PathVariable("id") Integer id) {
//		service.eliminar(id);
//	}
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Paciente obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
