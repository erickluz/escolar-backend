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
import com.erick.escolar.repositories.AulaRepository;
import com.erick.escolar.repositories.TurmaRepository;
import com.erick.escolar.services.exceptions.IntegridadeDeDados;
import com.erick.escolar.services.exceptions.ObjectNotFoundException;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaR;
	
	@Autowired
	private CursoService cursoS;
	
	@Autowired
	private MatriculaService matriculaS;
		
	@Autowired 
	ProfessorService professorS;
	
	@Autowired
	DisciplinaService disciplinaS;
	
	@Autowired
	AulaRepository aulaR;
	
	public List<Turma> listar(){
		return turmaR.findAll();
	}
	
	public Turma buscar(Integer id){
		Optional<Turma> obj = turmaR.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()));
	}
	
	public Turma inserir(Turma obj) {
		Curso curso = cursoS.buscar(obj.getCurso().getId());
		obj.setCurso(curso);
		for(Matricula matricula : obj.getMatriculas()) {
			matricula = matriculaS.buscar(matricula.getId());
		}		
		for (Aula aula: obj.getAulas()){			
			for(Professor professor: aula.getProfessores()) {
				System.out.println("Professor: " + professor.getId());
				professor = professorS.buscar(professor.getId());
			}
			aula.setDisciplina(disciplinaS.buscar(aula.getDisciplina().getId()));			
		}
		for (Aula aula: obj.getAulas()){
			aula.setTurma(obj);
		}	
		Turma objn = turmaR.save(obj);
		for (Aula aula: obj.getAulas()){
			aulaR.save(aula);
		}
		return objn;
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
			throw new IntegridadeDeDados("Nao se pode excluir Turmas que ja tenham Alunos ou Aulas");
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
