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

    @Override
    public Filme atualizarNomeFilme(Integer filmeId, String nome) {

        Filme filme = filmeRepo.obterPorIdFilme(filmeId);
        
        return filmeRepo.atualizarNomeFilme(filme, nome);
    }

    @Override
    public Filme atualizarCategoriaFilme(Integer filmeId, Integer categoria) {

        Filme filme = filmeRepo.obterPorIdFilme(filmeId);
        
        return filmeRepo.atualizarCategoriaFilme(filme, categoria);
    }

}
