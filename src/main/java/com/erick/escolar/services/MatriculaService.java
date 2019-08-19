package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Matricula;
import com.erick.escolar.repositories.MatriculaRepository;
import com.erick.escolar.services.exceptions.IntegridadeDeDados;
import com.erick.escolar.services.exceptions.ObjectNotFoundException;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository MatriculaR;
	
	public List<Matricula> listar(){
		return MatriculaR.findAll();
	}
	
	public Matricula buscar(Integer id){
		Optional<Matricula> obj = MatriculaR.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Matricula.class.getName()));
	}
	
	public Matricula inserir(Matricula obj) {
		return MatriculaR.save(obj);
	}
	
	public void alterar(Matricula obj) {
		buscar(obj.getId());
		MatriculaR.save(obj);
	}
	
	public void excluir(Integer id) {
		buscar(id);
		try {
			MatriculaR.deleteById(id);
		}catch (RuntimeException e) {
			throw new IntegridadeDeDados("Erro ao deletar Matriculas");
		}
	}
	
}
