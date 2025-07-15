package com.curso.ensino.dto;

import lombok.Data;

@Data
public class AlunoDTO {
    private Long id;
    private String nome;
    private String nomeCurso;

    public AlunoDTO(Long id, String nome, String nomeCurso) {
        this.id = id;
        this.nome = nome;
        this.nomeCurso = nomeCurso;
    }
}

