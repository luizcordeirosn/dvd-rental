package com.project.dvdrental.Filme.Service;

import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.Ator;
import com.project.dvdrental.Filme.Repository.AtorJpaRepository;

@Service
public class AtorServiceImpl implements AtorService {

    @Autowired
    private AtorJpaRepository atorJpaRepo;

    @Autowired
    private SessionFactory sf;

    @Override
    public Ator obterPorIdAtor(Integer id) throws Exception {

        Optional<Ator> optionalAtor = atorJpaRepo.findById(id);

        Ator ator = null;

        if (optionalAtor.isPresent()) {
            ator = optionalAtor.get();
        }else{
            throw new Exception("Usuário não encontrado");
        }

        return ator;
    }

    @Override
    public Ator obterPorNomeAtor(String primeiroNome, String ultimoNome) throws Exception {

        Optional<Ator> optionalAtor = atorJpaRepo.findByPrimeiroNomeAndUltimoNome(primeiroNome, ultimoNome);

        Ator ator = null;

        if (optionalAtor.isPresent()) {
            ator = optionalAtor.get();
        }else{
            throw new Exception("Usuário não encontrado");
        }

        return ator;
    }

    @Override
    public List<Ator> obterTodosAtoresPorFilme(Integer filme) {

        Session session = sf.openSession();

        String HQL = "select a from Ator a"
                + " inner join FilmeAtor fa on fa.atorId = a.atorId"
                + " where fa.filmeId = " + filme;

        List<Ator> lista = session.createQuery(HQL, Ator.class).list();

        return lista;
    }

    @Override
    public List<Ator> obterTodosAtoresPorPrimeiroNome(String nome) {

        List<Ator> lista = atorJpaRepo.findAllByPrimeiroNome(nome);

        return lista;
    }

    @Override
    public Ator salvarAtor(Ator ator) {

        return atorJpaRepo.save(ator);
    }

    @Override
    public Ator atualizarAtor(Ator ator) {
        
        return atorJpaRepo.save(ator);
    }

}
