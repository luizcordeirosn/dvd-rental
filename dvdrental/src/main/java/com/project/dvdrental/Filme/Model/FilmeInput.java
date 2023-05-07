package com.project.dvdrental.Filme.Model;

public class FilmeInput {
    
    private String titulo;
    private String descricao;
    private Integer anoLancamento;
    private Integer idioma;
    private Integer tempoAluguel;
    private Double avaliacaoAluguel;
    private Integer comprimento;
    private Double custoSubstituicao;
    private String funcionalidadesEspeciais;

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
    public Integer getIdioma() {
        return idioma;
    }
    public void setIdioma(Integer idioma) {
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
    public String getFuncionalidadesEspeciais() {
        return funcionalidadesEspeciais;
    }
    public void setFuncionalidadesEspeciais(String funcionalidadesEspeciais) {
        this.funcionalidadesEspeciais = funcionalidadesEspeciais;
    }
}
