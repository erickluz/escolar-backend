package com.erick.escolar;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.erick.escolar.domain.Curso;
import com.erick.escolar.domain.Disciplina;
import com.erick.escolar.repositories.CursoRepository;
import com.erick.escolar.repositories.DisciplinaRepository;

@SpringBootApplication
public class EscolarApplication implements CommandLineRunner{

	@Autowired
	DisciplinaRepository disciplinaR;
	
	@Autowired
	CursoRepository cursoR;
		
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
		
		
		
		disciplinaR.saveAll(Arrays.asList(d1, d2, d3, d4, d5));
		cursoR.saveAll(Arrays.asList(c1, c2));
		
		
		//curso
		
//		SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

//		Pessoa p1 = new Pessoa("Erick Candido da Luz", df1.parse("19/04/1995 10:10"), "43768646840", "Av. vereador Eduardo Cassanho", "312312312313", "443545424", data1);
//		Pessoa p2 = new Pessoa("Luiz Felipe Scolari", df1.parse("19/04/1995 10:10"), "00000000000", "Rio grande do sul", "546247653323", "23426456635", data1);
//		Pessoa p3 = new Pessoa("Adriano imperador", df1.parse("19/04/1995 10:10"), "1010110101010", "Rio de Janeiro", "342356416", "5342137455", data1);
//		
//		pessoaR.saveAll(Arrays.asList(p1, p2, p3));
		
		
		
		
	}

}

