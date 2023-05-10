package com.project.dvdrental.Filme.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer filmeId;

    @Column(name = "title")
    private String titulo;

    @Column(name = "description")
    private String descricao;

    @Column(name = "release_year")
    private Integer anoLancamento;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Idioma idioma;

    @Column(name = "rental_duration")
    private Integer tempoAluguel;

    @Column(name = "rental_rate")
    private Double avaliacaoAluguel;

    @Column(name = "length")
    private Integer comprimento;

    @Column(name = "replacement_cost")
    private Double custoSubstituicao;

    @Column(name = "rating")
    private String avaliacao;

    @Column(name = "last_update")
    private String ultimaAtualizacao;

    @Column(name = "special_features")
    private String funcionalidadesEspeciais;

    @Column(name = "fulltext")
    private String textoCompleto;

    public Integer getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Integer filmeId) {
        this.filmeId = filmeId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Integer getTempoAluguel() {
        return tempoAluguel;
    }

    public void setTempoAluguel(Integer tempoAluguel) {
        this.tempoAluguel = tempoAluguel;
    }

    public Double getAvaliacaoAluguel() {
        return avaliacaoAluguel;
    }

    public void setAvaliacaoAluguel(Double avaliacaoAluguel) {
        this.avaliacaoAluguel = avaliacaoAluguel;
    }

    public Integer getComprimento() {
        return comprimento;
    }

    public void setComprimento(Integer comprimento) {
        this.comprimento = comprimento;
    }

    public Double getCustoSubstituicao() {
        return custoSubstituicao;
    }

    public void setCustoSubstituicao(Double custoSubstituicao) {
        this.custoSubstituicao = custoSubstituicao;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getFuncionalidadesEspeciais() {
        return funcionalidadesEspeciais;
    }

    public void setFuncionalidadesEspeciais(String funcionalidadesEspeciais) {
        this.funcionalidadesEspeciais = funcionalidadesEspeciais;
    }

    public String getTextoCompleto() {
        return textoCompleto;
    }

    public void setTextoCompleto(String textoCompleto) {
        this.textoCompleto = textoCompleto;
    }
    
}
