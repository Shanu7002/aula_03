package com.exemplo.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.exemplo.biblioteca.model.Genero;

@Repository
public class GeneroRepository {
    private final List<Genero> genero = new ArrayList<>();

    public List<Genero> findAll() {
        return new ArrayList<>(genero);
    }
}
