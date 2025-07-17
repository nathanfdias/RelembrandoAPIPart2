package com.curso.ensino.dto;

import lombok.Data;

@Data
public class AlunoRequest {
    private String nome;
    private String cpf;
    private Long cursoId;
}
