package Exercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogador jogador = new Jogador();

        // Entrada de dados
        System.out.print("Digite o nome: ");
        jogador.nome = sc.nextLine();

        for (int i = 0; i < jogador.score.length; i++) {
            System.out.print("Score " + (i + 1) + ": ");
            jogador.score[i] = sc.nextInt();
        }

        // Saída de dados
        System.out.println();
        System.out.println("Nome: " + jogador.nome);
        System.out.println("Score: " + jogador.calcularScoreTotal());
    }
}
