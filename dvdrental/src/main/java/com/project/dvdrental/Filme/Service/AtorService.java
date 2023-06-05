package com.project.dvdrental.Filme.Service;

import java.util.List;
import com.project.dvdrental.Filme.Model.Ator;

public interface AtorService {

    Ator obterPorIdAtor(Integer id) throws Exception;

    Ator obterPorNomeAtor(String primeiroNome, String ultimoNome) throws Exception;

    List<Ator> obterTodosAtoresPorFilme(Integer filme);
    
    Ator salvarAtor(Ator ator);

    Ator atualizarAtor(Ator ator);
}