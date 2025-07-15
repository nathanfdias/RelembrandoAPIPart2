package com.curso.ensino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.ensino.dto.CursoDTO;
import com.curso.ensino.dto.CursoRequest;
import com.curso.ensino.service.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoDTO> criar(@RequestBody CursoRequest request) {
        return ResponseEntity.ok(cursoService.salvar(request));
    }

    @GetMapping
    public List<CursoDTO> listar() {
        return cursoService.listar();
    }
}
