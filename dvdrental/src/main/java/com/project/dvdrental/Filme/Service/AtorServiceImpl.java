package com.project.dvdrental.Filme.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.Ator;
import com.project.dvdrental.Filme.Repository.AtorJpaRepository;

@Service
public class AtorServiceImpl implements AtorService {

    @Autowired
    private AtorJpaRepository atorJpaRepo;

    @Override
    public Ator obterPorIdAtor(Integer id) {
        
        Optional<Ator> optionalAtor = atorJpaRepo.findById(id);

        Ator ator = null;

        if(optionalAtor.isPresent()){
            ator = optionalAtor.get();
        }

        return ator;
    }

    @Override
    public List<Ator> obterTodosAtoresPorFilme(Integer filme) {
        
        return atorJpaRepo.getAllByFilm(filme);
    }

    @Override
    public Ator salvarAtor(Ator ator) {
        
        return atorJpaRepo.save(ator);
    }
    
}
