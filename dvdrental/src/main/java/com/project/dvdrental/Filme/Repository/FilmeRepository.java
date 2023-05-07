package com.project.dvdrental.Filme.Repository;

import com.project.dvdrental.Filme.Model.Filme;

public interface FilmeRepository {

    Filme obterPorIdFilme(Integer id);
    
    Filme salvarFilme(Filme filme);
}
