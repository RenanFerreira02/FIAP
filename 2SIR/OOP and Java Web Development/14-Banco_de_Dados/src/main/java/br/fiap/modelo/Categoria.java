package br.fiap.modelo;

public class Categoria {
    private Long id;
    private String categoria;

    public Categoria(long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
