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

import com.project.dvdrental.Filme.Model.FilmeAtor;
import com.project.dvdrental.Filme.Service.FilmeAtorService;

@RestController
@RequestMapping(value = "/filmeator")
@Transactional
@Controller
public class FilmeAtorController {

    @Autowired
    private FilmeAtorService filmeAtorService;
    
    @GetMapping(value = "/obtertodos/filme/{filmeid}")
    public ResponseEntity<List<FilmeAtor>> atoresPorFilme(@PathVariable Integer filmeid) {

        List<FilmeAtor> lista = new ArrayList<FilmeAtor>();
        try {
            lista = filmeAtorService.obterTodosAtoresPorFilme(filmeid);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(lista);
    }
}
