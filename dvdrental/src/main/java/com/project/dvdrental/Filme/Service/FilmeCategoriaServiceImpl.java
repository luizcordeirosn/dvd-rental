package com.project.dvdrental.Filme.Service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dvdrental.Filme.Model.FilmeCategoria;

@Service
public class FilmeCategoriaServiceImpl implements FilmeCategoriaService{
    
    @Autowired
    private SessionFactory sf;

    @Override
    public List<FilmeCategoria> obterTodosFilmesPorCategoria(Integer categoria) {
        
        Session session = sf.openSession();

        String HQL = "select fc from FilmeCategoria fc"
                + " where fc.categoriaId = " + categoria;

        List<FilmeCategoria> lista = session.createQuery(HQL, FilmeCategoria.class).list();

        return lista;
    }
}
