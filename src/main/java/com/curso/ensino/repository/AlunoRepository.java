package com.curso.ensino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.ensino.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {}

