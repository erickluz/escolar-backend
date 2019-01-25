package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Aluno;
import com.erick.escolar.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoR;
	
	public List<Aluno> listar(){
		return alunoR.findAll();
	}
	
	public Optional<Aluno> buscar(Integer id){
		return alunoR.findById(id);
	}
	
}
