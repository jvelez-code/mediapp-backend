package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Paciente;


public interface ICRUD <T , ID >{
	T registrar (T pac) throws Exception ;
	T modificar (T pac) throws Exception ;
	List<T> listar()    throws Exception ;
	T listarPorId (ID id) throws Exception ;
	void eliminar (ID id) throws Exception ;
}
