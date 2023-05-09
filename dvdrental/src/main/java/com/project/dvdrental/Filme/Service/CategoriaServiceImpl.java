package com.project.dvdrental.Filme.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.Categoria;
import com.project.dvdrental.Filme.Repository.CategoriaJpaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaJpaRepository categoriaJpaRepo;

    @Override
    public Categoria obterPorIdCategoria(Integer id) {
        
        Optional<Categoria> optionalCategoria = categoriaJpaRepo.findById(id);

        Categoria ator = null;

        if(optionalCategoria.isPresent()){
            ator = optionalCategoria.get();
        }

        return ator;
    }

    @Override
    public Categoria salvarCategoria(Categoria ator) {
        
        return categoriaJpaRepo.save(ator);
    }
    
}
