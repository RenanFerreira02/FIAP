package Exercicio02;

import java.util.Scanner;

public class PlanilhaNotasFuncoes {

    static final int N = 30;

    public static void main(String[] args) {

        int[] rm = new int[N];
        double[] n1 = new double[N];
        double[] n2 = new double[N];
        double[] media = new double[N];

        int n = entradaDados(rm, n1, n2);

        if (n >= N)
            System.out.println("Numero de alunos e limitado a " + N);

        for (int i = 0; i < n; i++) {
            System.out.println("RM: " + rm[i] + "\t média: " + media[i]);
        }

        calculaMedia(n, n1, n2, media);

        int[] aprovados = new int[n];

        int nAp = geraListaAprovados(n, media, rm, aprovados);

        System.out.println("**** Alunos Aprovados *****");

        for (int i = 0; i < nAp; i++)
            System.out.println("RM: " + aprovados[i] + " Média: " + media[i]);
    }

    public static int entradaDados(int[] rm, double[] n1, double[] n2) {
        Scanner input = new Scanner(System.in);

        System.out.print("Informe RM do aluno ou valor negativo para encerrar: ");
        int rmLe = input.nextInt();

        int n = 0;

        while (rmLe > 0 && n < N) {
            rm[n] = rmLe;

            System.out.print("Nota1: ");
            n1[n] = input.nextDouble();

            System.out.print("Nota2: ");
            n2[n] = input.nextDouble();

            n++;

            System.out.print("Informe RM do aluno ou valor negativo para encerrar: ");
            rmLe = input.nextInt();
        }

        input.close();

        return n;
    }

    public static void calculaMedia(int n, double[] n1, double[] n2, double[] media) {
        for (int i = 0; i < n; i++) {
            media[i] = (n1[i] + n2[i]) / 2;
        }
    }

    public static int geraListaAprovados(int n, double[] media, int[] rm, int[] aprovados) {
        int nAp = 0;

        for (int i = 0; i < n; i++) {
            if (media[i] >= 6) {
                aprovados[nAp] = rm[i];

                nAp++;
            }
        }
        return nAp;
    }
}
