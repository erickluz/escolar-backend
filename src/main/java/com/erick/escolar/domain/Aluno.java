package com.erick.escolar.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Pessoa{

	private static final long serialVersionUID = 1L;
	private String RA;
	
	@OneToMany(mappedBy="aluno")
	private List<Matricula> matriculas = new ArrayList<>();
	
	public Aluno() {
		
	}

	public Aluno(Integer id, String nome, Date dataNascimento, String cpf, String endereco, String telefone1, String telefone2,
			Date dataCadastro, String RA) {
		super(id, nome, dataNascimento, cpf, endereco, telefone1, telefone2, dataCadastro);
		this.RA = RA;
	}

	public List<Matricula> getMatriculas(){
		return this.matriculas;
	}
	
	public void addMatricula(Matricula matricula) {
		this.matriculas.add(matricula);
	}
	
	public String getRA() {
		return RA;
	}

	public void setRA(String rA) {
		RA = rA;
	}
	
	
	
}
