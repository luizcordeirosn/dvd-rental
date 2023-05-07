package com.project.dvdrental.Filme.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.Filme;
import com.project.dvdrental.Filme.Repository.FilmeRepository;

@Service
public class FilmeServiceImpl implements FilmeService {

    @Autowired
    private FilmeRepository filmeRepo;

    @Override
    public Filme obterPorIdFilme(Integer id) {
        
        return filmeRepo.obterPorIdFilme(id);
    }

    @Override
    public Filme salvarFilme(Filme filme) {
        
        return filmeRepo.salvarFilme(filme);
    }

}
