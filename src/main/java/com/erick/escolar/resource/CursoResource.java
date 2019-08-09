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

import com.erick.escolar.domain.Curso;
import com.erick.escolar.services.CursoService;

@RestController
@RequestMapping(value="/curso")
public class CursoResource {

	@Autowired
	private CursoService cursoS;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(cursoS.listar());
	}
	
	@CrossOrigin
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		return ResponseEntity.ok(cursoS.buscar(id));
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Curso> inserir(@RequestBody Curso obj){
		cursoS.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Curso obj, @PathVariable Integer id){
		cursoS.alterar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		cursoS.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
}
