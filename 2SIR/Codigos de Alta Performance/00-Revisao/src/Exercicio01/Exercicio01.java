package Exercicio01;

import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int N = 30;

        int[] rm = new int[N];
        double[] n1 = new double[N];
        double[] n2 = new double[N];
        double[] media = new double[N];

        System.out.print("Informe RM do aluno ou valor negativo para encerrar: ");
        int rmLe = input.nextInt();

        int n = 0;

        while (rmLe > 0 && n < N) {
            rm[n] = rmLe;

            System.out.print("Nota1: ");
            n1[n] = input.nextDouble();

            System.out.print("Nota2: ");
            n2[n] = input.nextDouble();

            media[n] = (n1[n] + n2[n]) / 2;

            n++;

            System.out.print("Informe RM do aluno ou valor negativo para encerrar: ");
            rmLe = input.nextInt();
        }

        if (n >= N)
            System.out.println("Numero de alunos e limitado a " + N);

        for (int i = 0; i < n; i++) {
            System.out.println("RM: " + rm[i] + "\t média: " + media[i]);
        }

        int[] aprovados = new int[n];

        int nAp = 0;

        for (int i = 0; i < n; i++) {
            if (media[i] >= 6) {
                aprovados[nAp] = rm[i];
                nAp++;
            }
        }

        System.out.println("**** Alunos Aprovados *****");

        for (int i = 0; i < nAp; i++)
            System.out.println(aprovados[i]);

    }

}
