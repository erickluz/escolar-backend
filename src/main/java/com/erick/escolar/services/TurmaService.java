package com.erick.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.escolar.domain.Aula;
import com.erick.escolar.domain.Curso;
import com.erick.escolar.domain.Matricula;
import com.erick.escolar.domain.Professor;
import com.erick.escolar.domain.Turma;
import com.erick.escolar.dto.TurmaDTO;
import com.erick.escolar.repositories.TurmaRepository;
import com.erick.escolar.services.exceptions.IntegridadeDeDados;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaR;
	
	@Autowired
	private CursoService cursoS;
	
	@Autowired
	private MatriculaService matriculaS;
	
	@Autowired
	private AulaService aulaS;
	
	@Autowired 
	ProfessorService professorS;
	
	@Autowired
	DisciplinaService disciplinaS;
	
	public List<Turma> listar(){
		return turmaR.findAll();
	}
	
	public Optional<Turma> buscar(Integer id){	
		return turmaR.findById(id);
	}
	
	public Turma inserir(Turma obj) {
		System.out.println("a salvar: " + obj.toString());
		System.out.println("Curso: " + obj.getCurso().getId());
		
		Curso curso = cursoS.buscar(obj.getCurso().getId());
		
		obj.setCurso(curso);
		for(Matricula matricula : obj.getMatriculas()) {
			System.out.println("Matricula: " + matricula.getId());
			matricula = matriculaS.buscar(matricula.getId());
			
		}		
		
		for (Aula aula: obj.getAulas()){			
			System.out.println("Aula: " + aula.getId());
			for(Professor professor: aula.getProfessores()) {
				System.out.println("Professor: " + professor.getId());
				professor = professorS.buscar(professor.getId());
			}
			aula.setDisciplina(disciplinaS.buscar(aula.getDisciplina().getId()));
			aula = aulaS.inserir(aula);
			
		}		
		System.out.println("Salvando turma...: " + obj.toString());
		return turmaR.save(obj);
	}
	
	public void alterar(Turma obj) {
		buscar(obj.getId());
		turmaR.save(obj);
	}
	
	public void excluir(Integer id) {
		buscar(id);
		try {
			turmaR.deleteById(id);	
		} catch (RuntimeException e) {
			throw new IntegridadeDeDados("Nao se pode excluir Turmas que ja tenham Alunos e Disciplinas");
		}
		
	}
	
	public Turma fromDTO(TurmaDTO obj) {
		Turma t = new Turma(obj.getId(), obj.getNome(), obj.getDataInicio(), obj.getLocal());
		t.setCurso(obj.getCurso());
		t.setAulas(obj.getAulas());
		t.setMatriculas(obj.getMatriculas());
		return t;
	}
	
}
