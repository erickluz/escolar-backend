package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Disciplina;
import com.erick.escolar.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repo;
	
	public Optional<Disciplina> buscar(Integer id){
		return repo.findById(id);
	}
	
	public List<Disciplina> listar(){
		return repo.findAll();
	}
	
}
