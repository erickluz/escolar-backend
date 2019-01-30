package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Curso;
import com.erick.escolar.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoR;
	
	public Optional<Curso> buscar(Integer id){
		return cursoR.findById(id);
	}
	
	public List<Curso> listar(){
		return cursoR.findAll();
	}
	
	public Curso inserir(Curso obj) {
		return cursoR.save(obj);
	}
	
	public void alterar(Curso obj) {
		buscar(obj.getId());
		cursoR.save(obj);
	}
	
	public void excluir(Integer id) {
		buscar(id);
		cursoR.deleteById(id);
	}
	
	
}
