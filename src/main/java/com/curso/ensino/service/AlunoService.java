package com.curso.ensino.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ensino.dto.AlunoDTO;
import com.curso.ensino.dto.AlunoRequest;
import com.curso.ensino.model.Aluno;
import com.curso.ensino.model.Curso;
import com.curso.ensino.repository.AlunoRepository;
import com.curso.ensino.repository.CursoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public AlunoDTO salvar(AlunoRequest request) {
        Curso curso = cursoRepository.findById(request.getCursoId()).orElseThrow();
        Aluno aluno = Aluno.builder().nome(request.getNome()).curso(curso).build();
        Aluno salvo = alunoRepository.save(aluno);
        return new AlunoDTO(salvo.getId(), salvo.getNome(), curso.getNome());
    }

    public List<AlunoDTO> listar() {
        return alunoRepository.findAll().stream()
                .map(aluno -> new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getCurso().getNome()))
                .collect(Collectors.toList());
    }
}
