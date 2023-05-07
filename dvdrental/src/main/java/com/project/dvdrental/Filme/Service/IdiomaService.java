package com.project.dvdrental.Filme.Service;

import com.project.dvdrental.Filme.Model.Idioma;

public interface IdiomaService {
    
    Idioma obterPorIdIdioma(Integer id);

    Idioma obterPorFilmeIdioma(Integer filme);
    
}

