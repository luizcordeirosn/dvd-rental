package com.project.dvdrental.Filme.Service;

import java.util.List;
import com.project.dvdrental.Filme.Model.FilmeCategoria;

public interface FilmeCategoriaService {
    
    List<FilmeCategoria> obterTodosFilmesPorCategoria(Integer categoria);
}
