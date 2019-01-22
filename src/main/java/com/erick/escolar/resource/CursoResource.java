package com.erick.escolar.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erick.escolar.services.CursoService;

@RestController
@RequestMapping(value="/curso")
public class CursoResource {

	@Autowired
	private CursoService cursoS;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(cursoS.listar());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		return ResponseEntity.ok(cursoS.buscar(id));
	}
	
	
	
}
