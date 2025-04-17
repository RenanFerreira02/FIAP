package Exercicios;

import Filas.FilaString;

import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opc;

        FilaString queue = new FilaString();

        queue.init();

        do {
            System.out.println("1 - Insere o paciente na fila");
            System.out.println("2 - Retira o paciente da fila para o atendimento");
            System.out.println("3 - Encerra o atendimento");
            System.out.print("Opção: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Informe o PID do processo: ");
                    String nome = sc.next();

                    queue.enqueue(nome);

                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Não há processos na fila");
                    } else {
                        nome = queue.dequeue();

                        System.out.println("Processo " + nome + " está sendo executado");

                        System.out.println("... O processo foi concluído? (1-sim):");
                        int resp = sc.nextInt();

                        if (resp == 1) {
                            System.out.println("Processo " + nome + " foi concluido");
                        } else {
                            queue.enqueue(nome);
                        }
                    }
                    break;

                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Encerrando o Sistema");
                        break;
                    } else {
                        System.out.println("Ainda há processos na fila");

                        System.out.println("Deseja encerrar os processos? (1-sim):");
                        int resp = sc.nextInt();

                        if (resp == 1) {
                            while (!queue.isEmpty()) {
                                System.out.println("Processo " + queue.dequeue() + " foi encerrado");
                            }
                        } else {
                            opc = -1;
                        }
                    }
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opc != 3);

        sc.close();

    }
}
