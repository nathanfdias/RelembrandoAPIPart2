package com.curso.ensino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.ensino.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {}
