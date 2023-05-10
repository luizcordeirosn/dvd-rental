package com.project.dvdrental.Filme.Model;

import java.io.Serializable;

public class FilmeAtorPk implements Serializable {
    protected Ator atorId;
    protected Filme filmeId;

    public FilmeAtorPk() {}

    public FilmeAtorPk(Ator atorId, Filme filmeId) {
        this.atorId = atorId;
        this.filmeId = filmeId;
    }
}
