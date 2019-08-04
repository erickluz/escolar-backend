package com.erick.escolar.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Professor extends Pessoa{

	private static final long serialVersionUID = 1L;
	private String formacao;
	
	@JsonIgnore
	@ManyToMany(mappedBy="professores")
	private List<Aula> aulas = new ArrayList<>();
	
	public Professor() {
		
	}

	public Professor(Integer id, String nome, String sobrenome, String email, String senha, Date dataNascimento, String cpf, String endereco, String telefone1, String telefone2,
			Date dataCadastro, String formacao) {
		super(id, nome, sobrenome, email, senha, dataNascimento, cpf, endereco, telefone1, telefone2, dataCadastro);
		this.formacao = formacao;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	@Override
	public String toString() {
		return super.toString() + " Professor [formacao=" + formacao + ", aulas=" + aulas + "]";
	}
	
	
	
}
