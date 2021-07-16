package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Examen;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IExamenRepo;
import com.mitocode.service.IExamenService;

@Service
public class ExamenServiceImpl extends CRUDImpl<Examen, Integer> implements IExamenService {
	
	@Autowired
	private IExamenRepo repo;
	
	@Override
	public IGenericRepo<Examen, Integer> getRepo() {
		return repo;
	}
}

//	//instancia para evitar el nullpointexection
//	@Autowired
//	private IExamenRepo repo;
//	
//	@Override
//	public Examen registrar(Examen pac) {
//		return repo.save(pac); 
//	}
//
//	@Override
//	public Examen modificar(Examen pac) {
//		return repo.save(pac); 
//	}
//
//	@Override
//	public List<Examen> listar() {
//		return repo.findAll(); 
//	}
//
//	@Override
//	public Examen listarPorId(Integer id) {
//		Optional<Examen> op = repo.findById(id);
//		return op.isPresent() ? op.get() :new Examen();
//		
//	}
//
//	@Override
//	public void eliminar(Integer id) {
//		repo.deleteById(id); 
//		
//	}
//

