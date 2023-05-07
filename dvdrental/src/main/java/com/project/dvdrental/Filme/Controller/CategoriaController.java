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
import com.project.dvdrental.Filme.Model.Categoria;
import com.project.dvdrental.Filme.Model.CategoriaInput;
import com.project.dvdrental.Filme.Service.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
@Transactional
@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> categoria(@PathVariable Integer id) {

        Categoria categoria = new Categoria();
        try {
            categoria = categoriaService.obterPorIdCategoria(id);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(categoria);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody CategoriaInput categoriaInput)
            throws SQLException {

        Categoria categoria = new Categoria();

        categoria.setNome(categoriaInput.getNome());

        try {
            categoria = categoriaService.salvarCategoria(categoria);
        } catch (Exception e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return ResponseEntity.ok(categoria);
    }

}

