package com.project.dvdrental.Filme.Controller;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.dvdrental.Filme.Model.FilmeCategoria;
import com.project.dvdrental.Filme.Service.FilmeCategoriaService;

@RestController
@RequestMapping(value = "/filmecategoria")
@Transactional
@Controller
public class FilmeCategoriaController {

    @Autowired
    private FilmeCategoriaService filmeCategoriaService;
    
    @GetMapping(value = "/obtertodos/categoria/{categoriaid}")
    public ResponseEntity<List<FilmeCategoria>> filmesPorCategoria(@PathVariable Integer categoriaid) {

        List<FilmeCategoria> lista = new ArrayList<FilmeCategoria>();
        try {
            lista = filmeCategoriaService.obterTodosFilmesPorCategoria(categoriaid);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(lista);
    }
}