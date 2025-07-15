package com.curso.ensino.dto;

import java.util.List;

import lombok.Data;

@Data
public class CursoDTO {
    private Long id;
    private String nome;
    private List<String> alunos;

    public CursoDTO(Long id, String nome, List<String> alunos) {
        this.id = id;
        this.nome = nome;
        this.alunos = alunos;
    }
}
