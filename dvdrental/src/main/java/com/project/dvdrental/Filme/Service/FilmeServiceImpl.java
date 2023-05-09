package com.project.dvdrental.Filme.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.Filme;
import com.project.dvdrental.Filme.Repository.FilmeJpaRepository;
import com.project.dvdrental.Filme.Repository.FilmeRepository;

@Service
public class FilmeServiceImpl implements FilmeService {

    @Autowired
    private FilmeRepository filmeRepo;

    @Autowired
    private FilmeJpaRepository filmeJpaRepo;

    @Override
    public Filme obterPorIdFilme(Integer id) {
        
        Optional<Filme> optionalFilme = filmeJpaRepo.findById(id);

        Filme film = null;

        if(optionalFilme.isPresent()){
            film = optionalFilme.get();
        }

        return film;
    }

    @Override
    @Transactional
    public List<Filme> obterTodosFilmesPorCategoria(Integer id) {
        
        return filmeJpaRepo.getAllByCategory(id);
    }

    @Override
    @Transactional
    public Filme salvarFilme(Filme filme) {
        
        return filmeRepo.salvarFilme(filme);
    }

    @Override
    public Filme atualizarNomeFilme(Integer filmeId, String nome) {

        filmeJpaRepo.updateFilmName(nome, filmeId);

        Filme filme = obterPorIdFilme(filmeId);
        
        return filme;
    }

    @Override
    public Filme atualizarCategoriaFilme(Integer filmeId, Integer categoria) {

        filmeJpaRepo.updateFilmCategory(categoria, filmeId);

        Filme filme = obterPorIdFilme(filmeId);
        
        return filme;
    }

    @Override
    public Boolean deletarFilme(Filme filme) {
        
        return filmeRepo.deletarFilme(filme);
    }

}
