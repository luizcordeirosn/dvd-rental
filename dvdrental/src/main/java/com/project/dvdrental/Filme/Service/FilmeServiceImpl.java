package com.project.dvdrental.Filme.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    @Autowired
    private SessionFactory sf;

    @Override
    public Filme obterPorIdFilme(Integer id) {

        Optional<Filme> optionalFilme = filmeJpaRepo.findById(id);

        Filme film = null;

        if (optionalFilme.isPresent()) {
            film = optionalFilme.get();
        }

        return film;
    }

    @Override
    @Transactional
    public List<Filme> obterTodosFilmesPorCategoria(Integer id) {

        Session session = sf.openSession();

        String HQL = "select f from Filme f"
                + " inner join FilmeCategoria fc on fc.filmeId = f.filmeId"
                + " where fc.categoriaId = " + id;

        List<Filme> lista = session.createQuery(HQL, Filme.class).list();

        return lista;
    }

    @Override
    @Transactional
    public Filme salvarFilme(Filme filme) {

        return filmeRepo.salvarFilme(filme);
    }

    @Override
    public Filme atualizarNomeFilme(Integer filmeId, String nome) {

        Session session = sf.openSession();

        String HQL = "update Filme f set f.titulo = '" + nome + "' where f.filmeId =" + filmeId;

        Query query = session.createQuery(HQL);

        session.beginTransaction();
        query.executeUpdate();
        session.getTransaction().commit();

        Filme filme = obterPorIdFilme(filmeId);

        return filme;
    }

    @Override
    public Filme atualizarCategoriaFilme(Integer filmeId, Integer categoria) {

        Session session = sf.openSession();

        String HQL = "update FilmeCategoria fc set fc.categoriaId = " + categoria 
                + " where fc.filmeId = " + filmeId;

        Query query = session.createQuery(HQL);

        session.beginTransaction();
        query.executeUpdate();
        session.getTransaction().commit();

        Filme result = obterPorIdFilme(filmeId);

        return result;
    }

    @Override
    public Boolean deletarFilme(Filme filme) {

        return filmeRepo.deletarFilme(filme);
    }

}
