package com.erick.escolar.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Professor extends Pessoa{

	private static final long serialVersionUID = 1L;
	private String formacao;
	
	public Professor() {
		
	}

	public Professor(String nome, Date dataNascimento, String cpf, String endereco, String telefone1, String telefone2,
			Date dataCadastro, String formacao) {
		super(nome, dataNascimento, cpf, endereco, telefone1, telefone2, dataCadastro);
		this.formacao = formacao;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	
}
