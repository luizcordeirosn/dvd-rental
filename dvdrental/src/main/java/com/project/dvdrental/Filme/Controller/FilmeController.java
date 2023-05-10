package com.project.dvdrental.Filme.Controller;

import org.springframework.stereotype.Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.dvdrental.Filme.Model.Filme;
import com.project.dvdrental.Filme.Model.FilmeInput;
import com.project.dvdrental.Filme.Model.Idioma;
import com.project.dvdrental.Filme.Service.FilmeService;

@RestController
@RequestMapping(value = "/filme")
@Transactional
@Controller
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Filme> filme(@PathVariable Integer id) {

        Filme filme = new Filme();
        try {
            filme = filmeService.obterPorIdFilme(id);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(filme);
    }

    @GetMapping(value = "/obtertodos/categoria/{categoriaid}")
    public ResponseEntity<List<Filme>> filmesPorCategoria(@PathVariable Integer categoriaid) {

        List<Filme> lista = new ArrayList<Filme>();
        try {
            lista = filmeService.obterTodosFilmesPorCategoria(categoriaid);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Filme> salvarFilme(@RequestBody FilmeInput filmeInput)
            throws SQLException {

        Filme filme = new Filme();

        filme.setTitulo(filmeInput.getTitulo());
        filme.setDescricao(filmeInput.getDescricao());
        filme.setAnoLancamento(filmeInput.getAnoLancamento());
        
        Idioma idioma = new Idioma();
        idioma.setId(filmeInput.getIdioma());
        filme.setIdioma(idioma);

        filme.setTempoAluguel(filmeInput.getTempoAluguel());
        filme.setAvaliacaoAluguel(filmeInput.getAvaliacaoAluguel());
        filme.setComprimento(filmeInput.getComprimento());
        filme.setCustoSubstituicao(filmeInput.getCustoSubstituicao());
        filme.setFuncionalidadesEspeciais(filmeInput.getFuncionalidadesEspeciais());

        try {
            filme = filmeService.salvarFilme(filme);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(filme);
    }

    @PostMapping(value = "/atualizar/{filmeid}/nome")
    public ResponseEntity<Filme> atualizarNomeFilme(@PathVariable Integer filmeid, @RequestParam String titulo)
            throws SQLException {

        Filme filme = new Filme();

        try {
            filme = filmeService.atualizarNomeFilme(filmeid, titulo);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(filme);
    }

    @PostMapping(value = "/atualizar/{filmeid}/categoria/{categoriaid}")
    public ResponseEntity<Filme> atualizarCategoriaFilme(@PathVariable Integer filmeid,
            @PathVariable Integer categoriaid)
            throws SQLException {

        Filme filme = new Filme();

        try {
            filme = filmeService.atualizarCategoriaFilme(filmeid, categoriaid);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(filme);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Boolean> deletarMercadoria(@PathVariable Integer id) {

        Boolean ret = false;

        try {
            Filme filme = filmeService.obterPorIdFilme(id);
            ret = filmeService.deletarFilme(filme);

        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(ret);
    }

}
