package Exercicio03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Notebook", 5200, "Eletronico"));
        produtos.add(new Produto("Mesa de Jantar", 600, "Móvel"));
        produtos.add(new Produto("Celular", 2000, "Eletronico"));
        produtos.add(new Produto("Nike SB", 600, "Vestuário"));
        produtos.add(new Produto("Televisão", 900, "Eletronico"));

//      Predicado (Filtro Lógico) para ser aplicado nos produtos

        Predicate<Produto> filtroProduto = produto -> produto.categoria().equals("Eletronico") && produto.preco() > 1000;
//
//        produtos.stream()
//                .filter(filtroProduto)
//                .sorted(Comparator.comparing(Produto::nome))
//                .forEach(System.out::println);

        List<Produto> aux = produtos.stream()
                .filter(filtroProduto)
                .sorted(Comparator.comparing(Produto::nome))
                .map(p -> new Produto(p.nome().toUpperCase(), p.preco() * 0.9, p.categoria()))
                .toList();

        aux.forEach(System.out::println);

    }
}
