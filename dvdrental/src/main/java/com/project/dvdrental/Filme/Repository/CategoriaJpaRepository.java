package com.project.dvdrental.Filme.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.dvdrental.Filme.Model.Categoria;

@Repository
public interface CategoriaJpaRepository extends JpaRepository<Categoria, Integer> {
    
}
