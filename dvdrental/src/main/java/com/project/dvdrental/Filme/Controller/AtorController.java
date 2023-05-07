package com.project.dvdrental.Filme.Controller;

import org.springframework.stereotype.Controller;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.dvdrental.Filme.Model.Ator;
import com.project.dvdrental.Filme.Model.AtorInput;
import com.project.dvdrental.Filme.Service.AtorService;

@RestController
@RequestMapping(value = "/ator")
@Transactional
@Controller
public class AtorController {

    @Autowired
    private AtorService atorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ator> ator(@PathVariable Integer id) {

        Ator ator = new Ator();
        try {
            ator = atorService.obterPorIdAtor(id);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(ator);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Ator> salvarFilme(@RequestBody AtorInput atorInput)
            throws SQLException {

        Ator ator = new Ator();

        ator.setPrimeiroNome(atorInput.getPrimeiroNome());
        ator.setUltimoNome(atorInput.getUltimoNome());

        try {
            ator = atorService.salvarAtor(ator);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(ator);
    }

}
