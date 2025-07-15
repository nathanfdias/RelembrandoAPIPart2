package com.curso.ensino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.ensino.dto.AlunoDTO;
import com.curso.ensino.dto.AlunoRequest;
import com.curso.ensino.service.AlunoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDTO> criar(@RequestBody AlunoRequest request) {
        return ResponseEntity.ok(alunoService.salvar(request));
    }

    @GetMapping
    public List<AlunoDTO> listar() {
        return alunoService.listar();
    }
}

