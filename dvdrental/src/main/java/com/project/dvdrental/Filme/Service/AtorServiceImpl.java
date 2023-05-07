package com.project.dvdrental.Filme.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.Ator;
import com.project.dvdrental.Filme.Repository.AtorRepository;

@Service
public class AtorServiceImpl implements AtorService {

    @Autowired
    private AtorRepository atorRepo;

    @Override
    public Ator obterPorIdAtor(Integer id) {
        
        return atorRepo.obterPorIdAtor(id);
    }

    @Override
    public List<Ator> obterTodosAtoresPorFilme(Integer filme) {
        
        return atorRepo.obterTodosAtoresPorFilme(filme);
    }

    @Override
    public Ator salvarAtor(Ator ator) {
        
        return atorRepo.salvarAtor(ator);
    }
    
}
