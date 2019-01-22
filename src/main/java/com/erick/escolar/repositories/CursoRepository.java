package com.erick.escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.escolar.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
