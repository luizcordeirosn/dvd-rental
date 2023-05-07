package com.project.dvdrental.Filme.Repository;

import com.project.dvdrental.Filme.Model.Filme;

public interface FilmeRepository {

    Filme obterPorIdFilme(Integer id);
    
    Filme salvarFilme(Filme filme);

    Filme atualizarNomeFilme(Filme filme, String nome);

    Filme atualizarCategoriaFilme(Filme filme, Integer categoria);
}
