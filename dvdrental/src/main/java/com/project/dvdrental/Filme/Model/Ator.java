package com.project.dvdrental.Filme.Model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "actor")
@DynamicInsert
@DynamicUpdate
public class Ator {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Integer atorId;

    @Column(name = "first_name")
    private String primeiroNome;

    @Column(name = "last_name")
    private String ultimoNome;

    @Column(name = "last_update", nullable = false)
    private Timestamp ultimaAtualizacao;
    
    public Integer getAtorId() {
        return atorId;
    }
    public void setAtorId(Integer atorId) {
        this.atorId = atorId;
    }
    public String getPrimeiroNome() {
        return primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }
    public String getUltimoNome() {
        return ultimoNome;
    }
    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }
    public Timestamp getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }
    public void setUltimaAtualizacao(Timestamp ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
