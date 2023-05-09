package com.project.dvdrental.Filme.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project.dvdrental.Filme.Model.Filme;

@Repository
public interface FilmeJpaRepository extends JpaRepository<Filme, Integer> {

    @Query(value = "select * from film f"
            + " inner join film_category fc on fc.film_id = f.film_id"
            + " where fc.category_id = :categoryid", nativeQuery = true)
    List<Filme> getAllByCategory(@Param("categoryid") Integer categoriaId);

    @Modifying
    @Query(value = "update film set title = :title where film_id = :filmid", nativeQuery = true)
    void updateFilmName(@Param("title") String titulo, @Param("filmid") Integer filmeId);

    @Modifying
    @Query(value = "update film_category set category_id = :categoryid where film_id = :filmid", nativeQuery = true)
    void updateFilmCategory(@Param("categoryid") Integer categoria, @Param("filmid") Integer filmeId);
}
