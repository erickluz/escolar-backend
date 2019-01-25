package com.erick.escolar.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erick.escolar.services.AlunoService;

@RestController
@RequestMapping(value="/aluno")
public class AlunoResource {

	@Autowired
	private AlunoService aluno;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(aluno.listar());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		return ResponseEntity.ok(aluno.buscar(id));
	}
	
}
