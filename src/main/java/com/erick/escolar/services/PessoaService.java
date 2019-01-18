package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Pessoa;
import com.erick.escolar.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public Optional<Pessoa> buscar(Integer id) {
		return repo.findById(id);
		
	}
	
	public List<Pessoa> listar(){
		return repo.findAll();
	}
	
}
