package com.project.dvdrental.Filme.Repository;

import com.project.dvdrental.Filme.Model.Ator;

public interface AtorRepository {

    Ator obterPorIdAtor(Integer id);
    
    Ator salvarAtor(Ator ator);
}
