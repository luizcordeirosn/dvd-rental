package com.project.dvdrental.Filme.Repository;

import java.util.List;
import com.project.dvdrental.Filme.Model.Filme;

public interface FilmeRepository {

    Filme obterPorIdFilme(Integer id);

    List<Filme> obterTodosFilmesPorCategoria(Integer categoria);
    
    Filme salvarFilme(Filme filme);

    Filme atualizarNomeFilme(Filme filme, String nome);

    Filme atualizarCategoriaFilme(Filme filme, Integer categoria);

    Boolean deletarFilme(Filme filme);
}
