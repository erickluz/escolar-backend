package com.erick.escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.escolar.domain.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{

}
