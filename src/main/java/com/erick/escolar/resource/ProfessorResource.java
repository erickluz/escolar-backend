package com.erick.escolar.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erick.escolar.services.ProfessorService;

@RestController
@RequestMapping(value="/professor")
public class ProfessorResource {

	@Autowired
	private ProfessorService professor;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(professor.listar());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		return ResponseEntity.ok(professor.buscar(id));
	}
	
}
