package com.project.dvdrental.Filme.Service;

import java.util.List;
import com.project.dvdrental.Filme.Model.Ator;

public interface AtorService {

    Ator obterPorIdAtor(Integer id);

    List<Ator> obterTodosAtoresPorFilme(Integer filme);
    
    Ator salvarAtor(Ator ator);
}