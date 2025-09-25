package aplicacao;

import java.util.Scanner;

import arvores.AVLint;

public class MenuAVL {

    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);

        int opcao;

        AVLint avl = new AVLint();

        do {
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir");
            System.out.println("2 - Mostra Fator de Balanceamento");
            opcao = le.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Encerrado o programa");

                    break;
                case 1:
                    System.out.print("Informe valor a ser inserido: ");
                    int valor = le.nextInt();

                    avl.root = avl.inserirH(avl.root, valor);

                    break;
                case 2:
                    System.out.println("Apresentacao da AVL");

                    avl.mostraFB(avl.root);

                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }while (opcao!=0);


    }

}