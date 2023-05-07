package com.project.dvdrental.Filme.Model;

public class Filme {

    private Integer filmeId;
    private String titulo;
    private String descricao;
    private Integer anoLancamento;
    private Idioma idioma;
    private Integer tempoAluguel;
    private Double avaliacaoAluguel;
    private Integer comprimento;
    private Double custoSubstituicao;
    private String avaliacao;
    private String ultimaAtualizacao;
    private String funcionalidadesEspeciais;
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
