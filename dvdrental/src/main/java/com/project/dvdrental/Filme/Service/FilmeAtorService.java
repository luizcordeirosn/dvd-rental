package com.project.dvdrental.Filme.Service;

import java.util.List;
import com.project.dvdrental.Filme.Model.FilmeAtor;

public interface FilmeAtorService {
    
    List<FilmeAtor> obterTodosAtoresPorFilme(Integer filme);
}
