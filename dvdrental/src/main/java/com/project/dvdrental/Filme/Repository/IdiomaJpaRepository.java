package com.project.dvdrental.Filme.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project.dvdrental.Filme.Model.Idioma;

@Repository
public interface IdiomaJpaRepository extends JpaRepository<Idioma, Integer> {

    // @Query(value = "select l.* from language l"
    //         + " inner join film f on f.language_id = l.language_id"
    //         + " where f.film_id = :filmid", nativeQuery = true)
    // Idioma getByFilm(@Param("filmid") Integer filmeId);
}
