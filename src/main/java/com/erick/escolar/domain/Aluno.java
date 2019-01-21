package com.erick.escolar.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Aluno extends Pessoa{

	private static final long serialVersionUID = 1L;
	private String RA;
	
	public Aluno() {
		
	}

	public Aluno(String nome, Date dataNascimento, String cpf, String endereco, String telefone1, String telefone2,
			Date dataCadastro, String RA) {
		super(nome, dataNascimento, cpf, endereco, telefone1, telefone2, dataCadastro);
		this.RA = RA;
	}

	public String getRA() {
		return RA;
	}

	public void setRA(String rA) {
		RA = rA;
	}
	
	
	
}
