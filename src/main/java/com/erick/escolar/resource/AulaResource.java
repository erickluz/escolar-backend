package com.erick.escolar.resource;

import java.net.URI;
import java.util.List;

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

import com.erick.escolar.domain.Aula;
import com.erick.escolar.domain.Turma;
import com.erick.escolar.services.AulaService;

@RestController
@RequestMapping(name = "/aula")
public class AulaResource {
	
	@Autowired
	private AulaService service;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Aula>> listarAulas(){
		return ResponseEntity.ok(this.service.listar());
	}
	
	@CrossOrigin
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		return ResponseEntity.ok(this.service.buscar(id));
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Turma> inserir(@RequestBody Aula obj, @PathVariable Integer id){
		this.service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Aula obj, @PathVariable Integer id){
		this.service.alterar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		this.service.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
}
