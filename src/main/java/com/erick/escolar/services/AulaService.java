package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Aula;
import com.erick.escolar.repositories.AulaRepository;
import com.erick.escolar.services.exceptions.IntegridadeDeDados;
import com.erick.escolar.services.exceptions.ObjectNotFoundException;

@Service
public class AulaService {

	@Autowired
	private AulaRepository AulaR;
		
	public List<Aula> listar(){
		return AulaR.findAll();
	}
	
	public Aula buscar(Integer id){
		Optional<Aula> obj = AulaR.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aula.class.getName()));
	}
	
	public Aula inserir(Aula obj) {
		return AulaR.save(obj);
	}
	
	public void alterar(Aula obj) {
		buscar(obj.getId());
		AulaR.save(obj);
	}
	
	public void excluir(Integer id) {
		buscar(id);
		try {
			AulaR.deleteById(id);
		}catch (RuntimeException e) {
			throw new IntegridadeDeDados("Erro ao deletar Aulas");
		}
	}
	
}
