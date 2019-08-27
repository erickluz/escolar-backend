package com.erick.escolar.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Matricula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Date dataMatricula;
	private Date dataEncerramento;
	
	@ManyToOne
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	@JsonIgnore
	@ManyToMany(mappedBy="matriculas")
	private List<Turma> turmas = new ArrayList<>();
	
	
	public Matricula() {
		
	}
	
	public Matricula(Integer id, Date dataMatricula, Date dataEncerramento) {
		super();
		this.id = id;
		this.dataMatricula = dataMatricula;
		this.dataEncerramento = dataEncerramento;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", dataMatricula=" + dataMatricula + ", dataEncerramento=" + dataEncerramento
				+ ", curso=" + curso + ", aluno=" + aluno + ", turmas=" + turmas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
