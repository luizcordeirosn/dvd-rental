package com.project.dvdrental.Filme.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.Idioma;
import com.project.dvdrental.Filme.Repository.IdiomaJpaRepository;

@Service
public class IdiomaServiceImpl implements IdiomaService {
    
    @Autowired
    private IdiomaJpaRepository idiomaJpaRepo;

    @Override
    public Idioma obterPorIdIdioma(Integer id) {
        
        Optional<Idioma> optionalIdioma = idiomaJpaRepo.findById(id);

        Idioma idioma = null;

        if(optionalIdioma.isPresent()){
            idioma = optionalIdioma.get();
        }

        return idioma;
    }

    @Override
    public Idioma obterPorFilmeIdioma(Integer filme) {
        
        return idiomaJpaRepo.getByFilm(filme);
    }
    
}
