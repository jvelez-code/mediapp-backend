package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Paciente;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPacienteRepo;
import com.mitocode.service.IPacienteService;

@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService {
	
	@Autowired
	private IPacienteRepo repo;
	
	@Override
	public IGenericRepo<Paciente, Integer> getRepo() {
		return repo;
	}
}

//	//instancia para evitar el nullpointexection
//	@Autowired
//	private IPacienteRepo repo;
//	
//	@Override
//	public Paciente registrar(Paciente pac) {
//		return repo.save(pac); 
//	}
//
//	@Override
//	public Paciente modificar(Paciente pac) {
//		return repo.save(pac); 
//	}
//
//	@Override
//	public List<Paciente> listar() {
//		return repo.findAll(); 
//	}
//
//	@Override
//	public Paciente listarPorId(Integer id) {
//		Optional<Paciente> op = repo.findById(id);
//		return op.isPresent() ? op.get() :new Paciente();
//		
//	}
//
//	@Override
//	public void eliminar(Integer id) {
//		repo.deleteById(id); 
//		
//	}
//

