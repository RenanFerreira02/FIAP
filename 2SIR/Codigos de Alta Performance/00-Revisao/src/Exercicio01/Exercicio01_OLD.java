package Exercicio01;

import java.util.Scanner;

public class Exercicio01_OLD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] rm = new int[30];
        double[] n1 = new double[30];
        double[] n2 = new double[30];
        double[] media = new double[30];


        System.out.print("Digite o RM do aluno: ");
        int rmInput = input.nextInt();

        for (int i = 0; rmInput > 0; i++) {
            rm[i] = rmInput;

            System.out.print("Nota 1: ");
            n1[i] = input.nextInt();

            System.out.print("Nota 2: ");
            n2[i] = input.nextInt();

            media[i] = (n1[i] + n2[i]) / 2;

            System.out.println("\nRM: " + rm[i] + " Média: " + media[i]);

            System.out.print("\nDigite o RM do aluno: ");
            rmInput = input.nextInt();

        }

        int[] aprovados = new int[media.length];

        for (int i = 0; i < media.length; i++) {
            int j = 0;

            if (media[i] > 6) {
                aprovados[j] = rm[i];
                j++;
            }

            for (int k = 0; k < j; k++) {
                System.out.print("\nAprovados: " + aprovados[k]);
            }
        }


    }
}