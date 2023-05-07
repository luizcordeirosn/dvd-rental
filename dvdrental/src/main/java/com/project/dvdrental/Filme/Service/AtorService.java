package com.project.dvdrental.Filme.Service;

import com.project.dvdrental.Filme.Model.Ator;

public interface AtorService {

    Ator obterPorIdAtor(Integer id);
    
    Ator salvarAtor(Ator ator);
}