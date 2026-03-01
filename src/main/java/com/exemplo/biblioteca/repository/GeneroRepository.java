package com.exemplo.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.exemplo.biblioteca.model.Genero;

@Repository
public class GeneroRepository {
    private final List<Genero> generos = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public GeneroRepository() {
        save(new Genero(null, "Drama"));
        save(new Genero(null, "Terror"));
        save(new Genero(null, "Ação"));
    }

    public Genero save(Genero genero) {
        if (genero.getId() == null) {
            genero.setId(sequence.incrementAndGet());
            generos.add(genero);
        }
        deleteById(genero.getId());
        generos.add(genero);
        return genero;
    }


    public List<Genero> findAll() {
        return new ArrayList<>(generos);
    }

    public Optional<Genero> findById(Long id) {
        return generos.stream()
            .filter(genero -> genero.getId().equals(id))
            .findFirst();
    }

    public void deleteById(Long id) {
        generos.removeIf(genero -> genero.getId().equals(id));
    }
}
