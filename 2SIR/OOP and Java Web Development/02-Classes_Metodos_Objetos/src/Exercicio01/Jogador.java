package Exercicio01;

public class Jogador {

    // Atributos ou variáveis de instância
    String nome;

    int[] score = new int[3];

    // Método para calcular e retornar o score total
    public int calcularScoreTotal() {
        int total = 0;

        for (int i : score) {
            total += i;
        }

        return total;
    }
}
