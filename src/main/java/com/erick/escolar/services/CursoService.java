package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Curso;
import com.erick.escolar.repositories.CursoRepository;
import com.erick.escolar.services.exceptions.IntegridadeDeDados;
import com.erick.escolar.services.exceptions.ObjectNotFoundException;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoR;
	
	public Curso buscar(Integer id){
		Optional<Curso> curso = cursoR.findById(id); 
		return curso.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Curso.class.getName()));
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
		try {
			cursoR.deleteById(id);
		} catch (RuntimeException e) {
			throw new IntegridadeDeDados("Nao se pode deletar Cursos que estejam em Turmas");
		}
	}
	
	
}
