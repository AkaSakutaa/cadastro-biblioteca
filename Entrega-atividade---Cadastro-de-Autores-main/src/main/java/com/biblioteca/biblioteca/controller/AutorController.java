package com.biblioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.repository.AutorRepositorio;

@Controller
public class AutorController {

    private final AutorRepositorio autorRepositorio;

    public AutorController(AutorRepositorio autorRepositorio) {
        this.autorRepositorio = autorRepositorio;
    }

    @GetMapping("/autores/novo")
    public String abrirFormulario(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping("/autores")
    public String salvarAutor(@ModelAttribute Autor autor) {
        autorRepositorio.listar().add(autor);
        return "redirect:/autores";
    }

    @GetMapping("/autores")
    public String mostrarAutores(Model model) {
        model.addAttribute("autores", autorRepositorio.listar());
        return "autores/lista";
    }

    @GetMapping("/autores/excluir/{posicao}")
    public String excluirAutor(@PathVariable int posicao) {
        autorRepositorio.listar().remove(posicao);
        return "redirect:/autores";
    }
}