package com.project.dvdrental.Filme.Repository;

import java.util.List;
import com.project.dvdrental.Filme.Model.Ator;

public interface AtorRepository {

    Ator obterPorIdAtor(Integer id);

    List<Ator> obterTodosAtoresPorFilme(Integer filme);
    
    Ator salvarAtor(Ator ator);
}
