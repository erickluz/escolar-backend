package com.erick.escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.escolar.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
