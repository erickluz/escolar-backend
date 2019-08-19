package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Disciplina;
import com.erick.escolar.repositories.DisciplinaRepository;
import com.erick.escolar.services.exceptions.IntegridadeDeDados;
import com.erick.escolar.services.exceptions.ObjectNotFoundException;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repo;
	
	public Disciplina buscar(Integer id){
		Optional<Disciplina> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Disciplina.class.getName()));
	}
	
	public List<Disciplina> listar(){
		return repo.findAll();
	}
	
	public Disciplina inserir(Disciplina obj) {
		return repo.save(obj);
	}
	
	public void alterar(Disciplina obj) {
		buscar(obj.getId());
		repo.save(obj);
	}
	
	public void excluir(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}catch (RuntimeException e) {
			throw new IntegridadeDeDados("Existem cursos cadastrados com essa disciplina!");
		}
	}
	
}
