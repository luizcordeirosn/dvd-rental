package com.project.dvdrental.Filme.Service;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.Idioma;
import com.project.dvdrental.Filme.Repository.IdiomaJpaRepository;

@Service
public class IdiomaServiceImpl implements IdiomaService {

    @Autowired
    private IdiomaJpaRepository idiomaJpaRepo;

    @Autowired
    private SessionFactory sf;

    @Override
    public Idioma obterPorIdIdioma(Integer id) {

        Optional<Idioma> optionalIdioma = idiomaJpaRepo.findById(id);

        Idioma idioma = null;

        if (optionalIdioma.isPresent()) {
            idioma = optionalIdioma.get();
        }

        return idioma;
    }

    @Override
    public Idioma obterPorFilmeIdioma(Integer filme) {

        Session session = sf.openSession();

        String HQL = "select i from Idioma i"
                + " inner join Filme f on f.idioma = i.id"
                + " where f.filmeId = " + filme;

        Idioma idioma = session.createQuery(HQL, Idioma.class).uniqueResult();

        return idioma;
    }

}
