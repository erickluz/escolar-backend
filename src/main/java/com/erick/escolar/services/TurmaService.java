package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Turma;
import com.erick.escolar.repositories.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaR;
	
	public List<Turma> listar(){
		return turmaR.findAll();
	}
	
	public Optional<Turma> buscar(Integer id){
		return turmaR.findById(id);
	}
	
}
