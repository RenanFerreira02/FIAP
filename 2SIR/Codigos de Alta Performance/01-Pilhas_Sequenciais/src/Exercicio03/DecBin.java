package Exercicio03;

import Pilhas.PilhaInt;

import java.util.Scanner;

public class DecBin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimal, resto;

        System.out.print("Informe valor em decimal(inteiro positivo): ");
        decimal = sc.nextInt();

        PilhaInt pilha = new PilhaInt();

        pilha.init();

        while (decimal != 0) {
            resto = decimal % 2;

            pilha.push(resto);

            decimal = decimal / 2;
        }

        System.out.println("Valor em binario: ");
        pilha.esvazia();

        sc.close();
    }
}
