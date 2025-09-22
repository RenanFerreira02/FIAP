package Exercicio03;

public record Produto(String nome, double preco, String categoria) {
    @Override
    public String nome() {
        return nome;
    }

    @Override
    public double preco() {
        return preco;
    }

    @Override
    public String categoria() {
        return categoria;
    }
}

