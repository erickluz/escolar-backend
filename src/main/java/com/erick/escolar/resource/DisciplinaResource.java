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

import com.erick.escolar.domain.Disciplina;
import com.erick.escolar.services.DisciplinaService;

@RestController
@RequestMapping(value="/disciplina")
public class DisciplinaResource {

	@Autowired
	private DisciplinaService disciplina;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(disciplina.listar());
	}
	
	@CrossOrigin
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		return ResponseEntity.ok(disciplina.buscar(id));
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Disciplina> inserir(@RequestBody Disciplina obj){
		disciplina.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Disciplina obj, @PathVariable Integer id){
		disciplina.alterar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		disciplina.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
