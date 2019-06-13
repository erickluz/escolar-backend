package com.erick.escolar.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.erick.escolar.domain.Professor;
import com.erick.escolar.services.ProfessorService;

@RestController
@RequestMapping(value="/professor")
public class ProfessorResource {

	@Autowired
	private ProfessorService professor;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(professor.listar());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		return ResponseEntity.ok(professor.buscar(id));
	}
	
	@PostMapping
	public ResponseEntity<Professor> inserir(@RequestBody Professor obj){
		professor.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Professor obj, @PathVariable Integer id){
		professor.alterar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		professor.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
