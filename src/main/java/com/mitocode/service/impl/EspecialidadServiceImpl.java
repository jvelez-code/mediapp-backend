package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Especialidad;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IEspecialidadRepo;
import com.mitocode.service.IEspecialidadService;

@Service
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad, Integer> implements IEspecialidadService {
	
	@Autowired
	private IEspecialidadRepo repo;
	
	@Override
	public IGenericRepo<Especialidad, Integer> getRepo() {
		return repo;
	}
}

//	//instancia para evitar el nullpointexection
//	@Autowired
//	private IEspecialidadRepo repo;
//	
//	@Override
//	public Especialidad registrar(Especialidad pac) {
//		return repo.save(pac); 
//	}
//
//	@Override
//	public Especialidad modificar(Especialidad pac) {
//		return repo.save(pac); 
//	}
//
//	@Override
//	public List<Especialidad> listar() {
//		return repo.findAll(); 
//	}
//
//	@Override
//	public Especialidad listarPorId(Integer id) {
//		Optional<Especialidad> op = repo.findById(id);
//		return op.isPresent() ? op.get() :new Especialidad();
//		
//	}
//
//	@Override
//	public void eliminar(Integer id) {
//		repo.deleteById(id); 
//		
//	}
//

