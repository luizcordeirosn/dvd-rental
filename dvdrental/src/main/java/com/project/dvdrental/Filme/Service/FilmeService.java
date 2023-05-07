package com.project.dvdrental.Filme.Service;

import java.util.List;
import com.project.dvdrental.Filme.Model.Filme;

public interface FilmeService {

    Filme obterPorIdFilme(Integer id);

    List<Filme> obterTodosFilmesPorCategoria(Integer categoria);
    
    Filme salvarFilme(Filme filme);

    Filme atualizarNomeFilme(Integer filmeId, String nome);

    Filme atualizarCategoriaFilme(Integer filmeId, Integer categoria);
    
}
