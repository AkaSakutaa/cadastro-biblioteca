package com.biblioteca.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.biblioteca.biblioteca.model.Autor;

@Component
public class AutorRepositorio {

    private final List<Autor> autores = new ArrayList<>();

    public List<Autor> listar() {
        return autores;
    }
}