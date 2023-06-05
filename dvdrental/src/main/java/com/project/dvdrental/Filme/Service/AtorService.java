package com.project.dvdrental.Filme.Service;

import java.util.List;

import com.project.dvdrental.Filme.Dto.AtorDto;
import com.project.dvdrental.Filme.Model.Ator;

public interface AtorService {

    Ator ator(Integer id) throws Exception;

    AtorDto obterPorIdAtor(Integer id) throws Exception;

    Ator obterPorNomeAtor(String primeiroNome, String ultimoNome) throws Exception;

    List<Ator> obterTodosAtoresPorFilme(Integer filme);

    List<Ator> obterTodosAtoresPorPrimeiroNome(String nome);
    
    Ator salvarAtor(Ator ator);

    Ator atualizarAtor(Ator ator);
}