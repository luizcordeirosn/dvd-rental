package com.project.dvdrental.Filme.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.Idioma;
import com.project.dvdrental.Filme.Repository.IdiomaRepository;

@Service
public class IdiomaServiceImpl implements IdiomaService {
    
    @Autowired
    private IdiomaRepository idiomaRepo;

    @Override
    public Idioma obterPorIdIdioma(Integer id) {
        
        return idiomaRepo.obterPorIdIdioma(id);
    }
    
}
