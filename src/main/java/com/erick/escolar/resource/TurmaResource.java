package com.erick.escolar.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erick.escolar.services.TurmaService;

@RestController
@RequestMapping(value="/turma")
public class TurmaResource {
	
	@Autowired
	private TurmaService turma;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(turma.listar());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		return ResponseEntity.ok(turma.buscar(id));
	}
	
}
