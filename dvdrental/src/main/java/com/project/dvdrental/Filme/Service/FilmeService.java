package com.project.dvdrental.Filme.Service;

import com.project.dvdrental.Filme.Model.Filme;

public interface FilmeService {

    Filme obterPorIdFilme(Integer id);
    
    Filme salvarFilme(Filme filme);

    Filme atualizarNomeFilme(Integer filmeId, String nome);
    
}
