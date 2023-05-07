package com.project.dvdrental.Filme.Model;

public class Ator {
    
    private Integer atorId;
    private String primeiroNome;
    private String ultimoNome;
    private String ultimaAtualizacao;
    
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
    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }
    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
