package com.project.dvdrental.Filme.Model;

import java.io.Serializable;

public class FilmeCategoriaPk implements Serializable {
    protected Filme filmeId;
    protected Categoria categoriaId;

    public FilmeCategoriaPk() {}

    public FilmeCategoriaPk(Filme filmeId, Categoria categoriaId) {
        this.filmeId = filmeId;
        this.categoriaId = categoriaId;
    }
}
