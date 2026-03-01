package com.exemplo.biblioteca.service;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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

    public Genero getById(Long id) {
        return generoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Genero não encontrado"));
    }

    public Genero addGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    public void deleteById(Long id) {
        generoRepository.deleteById(id);
    }
}
