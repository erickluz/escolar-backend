package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Aluno;
import com.erick.escolar.repositories.AlunoRepository;
import com.erick.escolar.services.exceptions.IntegridadeDeDados;

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
	
	public Aluno inserir(Aluno obj) {
		return alunoR.save(obj);
	}
	
	public void alterar(Aluno obj) {
		buscar(obj.getId());
		alunoR.save(obj);
	}
	
	public void excluir(Integer id) {
		buscar(id);
		try {
			alunoR.deleteById(id);
		}catch (RuntimeException e) {
			throw new IntegridadeDeDados("Erro ao deletar alunos");
		}
	}
	
}
