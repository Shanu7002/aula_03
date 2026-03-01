package com.exemplo.biblioteca.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping("/{id}")
    public Genero getGeneroById(@PathVariable Long id) {
        return generoService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genero postGeneroById(@RequestBody Genero genero) {
        return generoService.addGenero(genero);
    }

    @DeleteMapping("/{id}")
    public void deleteGeneroById(@PathVariable Long id) {
        generoService.deleteById(id);
    }
}
