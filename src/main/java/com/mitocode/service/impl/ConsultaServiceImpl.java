package com.mitocode.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dto.ConsultaListaExamenDTO;
import com.mitocode.dto.FiltroConsultaDTO;
import com.mitocode.model.Consulta;
import com.mitocode.repo.IConsultaExamenRepo;
import com.mitocode.repo.IConsultaRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IConsultaService;

@Service
public class ConsultaServiceImpl extends CRUDImpl<Consulta, Integer> implements IConsultaService {
	
	@Autowired
	private IConsultaRepo repo;
	
	@Autowired
	private IConsultaExamenRepo ceRepo;
	
	@Override
	public IGenericRepo<Consulta, Integer> getRepo() {
		return repo;
	}
	
	/*@Transactional
	@Override
	public Consulta registrarTransaccional(ConsultaListaExamenDTO dto) throws Exception {
    dto.getConsulta().getDetalleConsulta().forEach(det -> det.setConsulta(dto.getConsulta()));		
	
	
	repo.save(dto.getConsulta());
	
	dto.getLstExamen.forEach(exa -> ceRepo.registrar(dto.getConsulta().getIdConsulta(),exa.getIdExamen()));
	
	return dto.getConsulta();
}*/
	@Override
	public List<Consulta> buscar(FiltroConsultaDTO filtro){
		return repo.buscar(filtro.getDni(), filtro.getNombreCompleto());
		
	}
	
	@Override
	public List<Consulta> buscarFecha(FiltroConsultaDTO filtro){
		return repo.buscarFecha(filtro.getFechaConsulta(),filtro.getFechaConsulta().plusDays(1));
	}

	@Override
	public Consulta registrarTransaccional(ConsultaListaExamenDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
		
}


