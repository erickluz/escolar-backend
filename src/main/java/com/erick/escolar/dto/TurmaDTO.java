package com.erick.escolar.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.erick.escolar.domain.Aula;
import com.erick.escolar.domain.Curso;
import com.erick.escolar.domain.Matricula;
import com.erick.escolar.domain.Turma;

public class TurmaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Date dataInicio;
	private String local;
	private Curso curso;
	private List<Matricula> matriculas = new ArrayList<>();
	private List<Aula> aulas = new ArrayList<>();
	
	public TurmaDTO() {
		
	}
	
	public TurmaDTO(Turma obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.dataInicio = obj.getDataInicio();
		this.local = obj.getLocal();
		this.curso = obj.getCurso();
		this.matriculas = obj.getMatriculas();
		this.aulas = obj.getAulas();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	@Override
	public String toString() {
		return "TurmaDTO [id=" + id + ", nome=" + nome + ", dataInicio=" + dataInicio + ", local=" + local + ", curso="
				+ curso + ", matriculas=" + matriculas + ", aulas=" + aulas + "]";
	}
	
}
