package com.biblioteca.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.AutorRepositorio;

@Controller
public class LivroController {

    private List<Livro> listaLivros = new ArrayList<>();
    private final AutorRepositorio autorRepositorio;

    public LivroController(AutorRepositorio autorRepositorio) {
        this.autorRepositorio = autorRepositorio;
    }

    @GetMapping("/livros/novo")
    public String abrirFormulario(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("autores", autorRepositorio.listar());
        return "livros/form";
    }

    @GetMapping("/livros/excluir/{posicao}")
    public String excluirLivro(@PathVariable int posicao) {
        listaLivros.remove(posicao);
        return "redirect:/livros";
    }

    @PostMapping("/livros")
    public String salvarLivro(@ModelAttribute Livro livro) {
        listaLivros.add(livro);
        return "redirect:/livros";
    }

    @GetMapping("/livros")
    public String mostrarLivros(Model model) {
        model.addAttribute("livros", listaLivros);
        return "livros/lista";
    }
}