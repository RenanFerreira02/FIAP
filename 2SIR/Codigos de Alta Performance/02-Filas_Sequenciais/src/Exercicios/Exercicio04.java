package Exercicios;

import Filas.FilaInt;

import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opc;

        FilaInt queue = new FilaInt();

        queue.init();

        do {
            System.out.println("1 - Insere o processo na fila");
            System.out.println("2 - Retira o processo da fila para a execução");
            System.out.println("3 - Shutdown");
            System.out.print("Opção: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Informe o PID do processo: ");
                    int pid = sc.nextInt();

                    queue.enqueue(pid);

                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Não há processos na fila");
                    } else {
                        pid = queue.dequeue();

                        System.out.println("Processo " + pid + " está sendo executado");

                        System.out.println("... O processo foi concluído? (1-sim):");
                        int resp = sc.nextInt();

                        if (resp == 1) {
                            System.out.println("Processo " + pid + " foi concluido");
                        } else {
                            queue.enqueue(pid);
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
