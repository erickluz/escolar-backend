package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Professor;
import com.erick.escolar.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorR;
	
	public List<Professor> listar(){
		return professorR.findAll();
	}
	
	public Optional<Professor> buscar(Integer id){
		return professorR.findById(id);
	}
	
	public Professor inserir(Professor obj) {
		return professorR.save(obj);
	}
	
	public void alterar(Professor obj) {
		buscar(obj.getId());
		professorR.save(obj);
	}

	public void excluir(Integer id) {
		buscar(id);
		professorR.deleteById(id);
	}
	
}
