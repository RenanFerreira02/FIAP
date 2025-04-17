package Exercicios;

import Filas.FilaInt;

import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opc;

        FilaInt queue = new FilaInt();

        queue.init();

        do {
            System.out.println("1 - Insere o aluno na fila");
            System.out.println("2 - Retira o aluno da fila para o atendimento");
            System.out.println("3 - Encerra o atendimento");
            System.out.print("Opção: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Informe o RM do aluno: ");
                    int rm = sc.nextInt();

                    queue.enqueue(rm);

                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Não há alunos na fila");
                    } else {
                        System.out.println("Aluno a ser atendido: " + queue.dequeue());
                    }

                    break;
                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Atendimentos Encerrados");
                        break;
                    } else {
                        System.out.println("Ainda há alunos na fila");

                        opc = -1;
                    }
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opc != 3);

        sc.close();

    }
}
