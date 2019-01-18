package com.erick.escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.escolar.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
