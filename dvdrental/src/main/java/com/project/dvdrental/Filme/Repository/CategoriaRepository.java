package com.project.dvdrental.Filme.Repository;

import com.project.dvdrental.Filme.Model.Categoria;

public interface CategoriaRepository {

    Categoria obterPorIdCategoria(Integer id);
    
    Categoria salvarCategoria(Categoria categoria);
}
