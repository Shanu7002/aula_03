package com.exemplo.biblioteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exemplo.biblioteca.model.Genero;
import com.exemplo.biblioteca.service.GeneroService;


import java.util.List;

@RestController
@RequestMapping("api/genero")
public class GeneroController {
    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping
    public List<Genero> getGenero() {
        return generoService.getAll();
    }
}
