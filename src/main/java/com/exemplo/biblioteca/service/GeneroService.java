package com.exemplo.biblioteca.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.exemplo.biblioteca.model.Genero;
import com.exemplo.biblioteca.repository.GeneroRepository;

@Service
public class GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Genero> getAll() {
        return generoRepository.findAll();
    }
}
