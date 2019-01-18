package com.erick.escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.escolar.domain.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

}
