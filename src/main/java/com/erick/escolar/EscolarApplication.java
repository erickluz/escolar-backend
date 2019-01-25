package com.erick.escolar;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.erick.escolar.domain.Aluno;
import com.erick.escolar.domain.Aula;
import com.erick.escolar.domain.Curso;
import com.erick.escolar.domain.Disciplina;
import com.erick.escolar.domain.Professor;
import com.erick.escolar.domain.Turma;
import com.erick.escolar.repositories.AlunoRepository;
import com.erick.escolar.repositories.AulaRepository;
import com.erick.escolar.repositories.CursoRepository;
import com.erick.escolar.repositories.DisciplinaRepository;
import com.erick.escolar.repositories.ProfessorRepository;
import com.erick.escolar.repositories.TurmaRepository;

@SpringBootApplication
public class EscolarApplication implements CommandLineRunner{

	@Autowired
	DisciplinaRepository disciplinaR;
	
	@Autowired
	CursoRepository cursoR;
	
	@Autowired
	AlunoRepository alunoR;
	
	@Autowired
	TurmaRepository turmaR;
	
	@Autowired
	ProfessorRepository professorR;
	
	@Autowired
	AulaRepository aulaR;
		
	public static void main(String[] args) {
		SpringApplication.run(EscolarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Curso c1 = new Curso(null, "Engenharia Civil", "Curso de aprender a bater concreto direito");
		Curso c2 = new Curso(null, "Ciencia da Computacao", "Curso para aprender formatar pc");
		
		Date data1 = new Date();
		data1.getTime();
		
		Disciplina d1 = new Disciplina(null, "Portugues", data1, "");
		Disciplina d2 = new Disciplina(null, "Matematica", data1, "");
		Disciplina d3 = new Disciplina(null, "Fisica", data1, "");
		Disciplina d4 = new Disciplina(null, "Quimica", data1, "");
		Disciplina d5 = new Disciplina(null, "Biologia", data1, "");
		
		d1.getCursos().addAll(Arrays.asList(c1, c2));
		
		c1.getDisciplinas().addAll(Arrays.asList(d1));
		c2.getDisciplinas().addAll(Arrays.asList(d1));
		
		
		
		Aluno al1 = new Aluno(null, "Erick Luz", data1, "123456789", "Av. das oportunidades", "3332-1221", "14 988334145", data1, "123456789");
		
		
		
		Turma t1 = new Turma(null, "3-B", data1, "Terreo");
		Turma t2 = new Turma(null, "2-B", data1, "Terreo");
		Turma t3 = new Turma(null, "1-B", data1, "Terreo");
		
		Turma t4 = new Turma(null, "1-B", data1, "1o Andar");
		Turma t5 = new Turma(null, "2-B", data1, "1o Andar");			
		
		Professor p1 = new Professor(null, "Adriano Imperador", data1, "123242341", "Rocinha", "3333-1111","99399-9999", data1, "Letras");
		
		SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Aula a1 = new Aula(null, df1.parse("19/01/2019 22:00"), df1.parse("19/01/2019 22:00"));
		
		p1.setAulas(Arrays.asList(a1));
		a1.setProfessor(p1);
		a1.setTurma(t1);
		
		disciplinaR.saveAll(Arrays.asList(d1, d2, d3, d4, d5));
		cursoR.saveAll(Arrays.asList(c1, c2));
		alunoR.save(al1);
		turmaR.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		professorR.save(p1);
		aulaR.save(a1);
		
	}

}

