package com.project.dvdrental.Filme.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.dvdrental.Filme.Model.Idioma;
import com.project.dvdrental.Filme.Service.IdiomaService;

@RestController
@RequestMapping(value = "/idioma")
@Transactional
@Controller
public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Idioma> idioma(@PathVariable Integer id) {

        Idioma idioma = new Idioma();
        try {
            idioma = idiomaService.obterPorIdIdioma(id);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(idioma);
    }

    @GetMapping(value = "/filme/{filmeid}")
    public ResponseEntity<Idioma> idiomaFilme(@PathVariable Integer filmeid) {

        Idioma idioma = new Idioma();
        try {
            idioma = idiomaService.obterPorFilmeIdioma(filmeid);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(idioma);
    }
}

