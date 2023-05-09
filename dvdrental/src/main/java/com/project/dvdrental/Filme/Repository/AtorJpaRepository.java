package com.project.dvdrental.Filme.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project.dvdrental.Filme.Model.Ator;

@Repository
public interface AtorJpaRepository extends JpaRepository<Ator, Integer> {

    @Query(value = "select * from actor a"
            + " inner join film_actor fa on fa.actor_id = a.actor_id"
            + " where fa.film_id = :filmid", nativeQuery = true)
    List<Ator> getAllByFilm(@Param("filmid") Integer filmeId);
}
