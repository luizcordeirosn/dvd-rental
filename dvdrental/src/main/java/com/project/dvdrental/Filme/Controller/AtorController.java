package com.project.dvdrental.Filme.Controller;

import org.springframework.stereotype.Controller;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/nome")
    public ResponseEntity<Ator> nomeAtor(@RequestParam String primeiroNome, @RequestParam String ultimoNome) {

        Ator ator = new Ator();
        try {
            ator = atorService.obterPorNomeAtor(primeiroNome, ultimoNome);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(ator);
    }

    @GetMapping(value = "/obtertodos/filme/{filmeid}")
    public ResponseEntity<List<Ator>> atoresPorFilme(@PathVariable Integer filmeid) {

        List<Ator> lista = new ArrayList<Ator>();
        try {
            lista = atorService.obterTodosAtoresPorFilme(filmeid);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Ator> salvarAtor(@RequestBody AtorInput atorInput)
            throws SQLException {

        Ator ator = new Ator();

        ator.setPrimeiroNome(atorInput.getPrimeiroNome());
        ator.setUltimoNome(atorInput.getUltimoNome());

        // Timestamp ultimaAtualizacao = new Timestamp(System.currentTimeMillis());
        // ator.setUltimaAtualizacao(ultimaAtualizacao);

        try {
            ator = atorService.salvarAtor(ator);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(ator);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity atualizarPrimeiroNomeAtor(@PathVariable Integer id, @RequestBody AtorInput atorInput)
            throws Exception {

        Ator ator = new Ator();

        try {

            ator = atorService.obterPorIdAtor(id);
            ator.setPrimeiroNome(atorInput.getPrimeiroNome());
            ator = atorService.atualizarAtor(ator);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(ator);
    }

}
