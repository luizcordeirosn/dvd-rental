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
@IdClass(FilmeAtorPk.class)
@Table(name = "film_actor")
public class FilmeAtor {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Ator atorId;

    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Filme filmeId;

    @Column(name = "last_update")
    private Timestamp ultimaAtualizacao;

    public Ator getAtorId() {
        return atorId;
    }

    public void setAtorId(Ator atorId) {
        this.atorId = atorId;
    }

    public Filme getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Filme filmeId) {
        this.filmeId = filmeId;
    }

    public Timestamp getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Timestamp ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
