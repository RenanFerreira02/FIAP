package Exercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Aluno aluno = new Aluno();

        System.out.print("Digite o RM do aluno: ");
        aluno.rm = input.nextInt();

        System.out.print("Digite o Nome do aluno: ");
        aluno.nome = input.next();

        System.out.print("Digite a primeira nota do aluno: ");
        aluno.n1 = input.nextInt();

        System.out.print("Digite a segunda nota do aluno: ");
        aluno.n2 = input.nextInt();

        System.out.println("\nMédia = " + aluno.calcularMedia());

        System.out.println("Status: " + aluno.verificaStatus());
    }
}

