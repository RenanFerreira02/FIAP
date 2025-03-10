package Exercicio02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Paciente p = new Paciente();
        double[] frequenciaAlvo;

        System.out.print("Digite o nome do Paciente: ");
        p.nome = sc.nextLine();

        System.out.print("Digite a idade do Paciente: ");
        p.idade = sc.nextInt();

        System.out.println("\nA frequência cardíaca máxima do paciente é " + p.frequenciaCardiacaMaxima());

        frequenciaAlvo = p.frequenciaCardiacaAlvo();

        System.out.println("\nA frequência alvo mínima do paciente é " + frequenciaAlvo[0]);

        System.out.println("A frequência alvo máxima do paciente é " + frequenciaAlvo[1]);
    }
}
