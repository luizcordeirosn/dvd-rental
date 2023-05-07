package com.project.dvdrental.Filme.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.Categoria;
import com.project.dvdrental.Filme.Repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Override
    public Categoria obterPorIdCategoria(Integer id) {
        
        return categoriaRepo.obterPorIdCategoria(id);
    }

    @Override
    public Categoria salvarCategoria(Categoria ator) {
        
        return categoriaRepo.salvarCategoria(ator);
    }
    
}
