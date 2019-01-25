package com.erick.escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.escolar.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
