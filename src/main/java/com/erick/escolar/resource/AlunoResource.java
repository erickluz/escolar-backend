package com.erick.escolar.resource;


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

import com.erick.escolar.domain.Aluno;
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
	
//	@CrossOrigin
//	@PostMapping
//	public ResponseEntity<Aluno> inserir(@RequestBody Aluno obj){
//		System.out.println(obj.toStr);
//		aluno.inserir(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build(); 
//	}
	
	@CrossOrigin
	@PostMapping
	public void inserir(@RequestBody String obj){
		System.out.println(obj);
//		aluno.inserir(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build(); 
	}	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Aluno obj, @PathVariable Integer id){
		aluno.alterar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		return ResponseEntity.noContent().build();
	}
	
	
}
