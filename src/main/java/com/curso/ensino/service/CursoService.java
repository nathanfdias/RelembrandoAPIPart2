package com.curso.ensino.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ensino.dto.CursoDTO;
import com.curso.ensino.dto.CursoRequest;
import com.curso.ensino.model.Curso;
import com.curso.ensino.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoDTO salvar(CursoRequest request) {
        Curso curso = Curso.builder().nome(request.getNome()).build();
        Curso salvo = cursoRepository.save(curso);
        return new CursoDTO(salvo.getId(), salvo.getNome(), List.of());
    }

    public List<CursoDTO> listar() {
        return cursoRepository.findAll().stream()
                .map(curso -> new CursoDTO(
                        curso.getId(),
                        curso.getNome(),
                        curso.getAlunos() == null ? List.of() : curso.getAlunos().stream()
                                .map(a -> a.getNome()).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow();
    }
}
