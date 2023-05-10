package com.project.dvdrental.Filme.Model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(FilmeCategoriaPk.class)
@Table(name = "film_category")
public class FilmeCategoria {

    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Filme filmeId;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categoria categoriaId;

    @Column(name = "last_update")
    private Timestamp ultimaAtualizacao;

    public Filme getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Filme filmeId) {
        this.filmeId = filmeId;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Timestamp getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Timestamp ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
