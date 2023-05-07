package com.project.dvdrental.Filme.Service;

import com.project.dvdrental.Filme.Model.Categoria;

public interface CategoriaService {

    Categoria obterPorIdCategoria(Integer id);
    
    Categoria salvarCategoria(Categoria categoria);
}
