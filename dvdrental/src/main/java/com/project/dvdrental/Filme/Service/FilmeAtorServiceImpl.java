package com.project.dvdrental.Filme.Service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.FilmeAtor;

@Service
public class FilmeAtorServiceImpl implements FilmeAtorService{

    @Autowired
    private SessionFactory sf;

    @Override
    public List<FilmeAtor> obterTodosAtoresPorFilme(Integer filme) {
        
        Session session = sf.openSession();

        String HQL = "select fa from FilmeAtor fa"
                + " where fa.filmeId = " + filme;

        List<FilmeAtor> lista = session.createQuery(HQL, FilmeAtor.class).list();

        return lista;
    }
    
}
