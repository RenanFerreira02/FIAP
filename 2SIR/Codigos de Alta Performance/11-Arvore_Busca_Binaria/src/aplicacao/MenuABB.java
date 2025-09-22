package aplicacao;

import java.util.Scanner;

import arvores.ABBint;

public class MenuABB {

    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);

        int opcao;

        ABBint abb = new ABBint();

        do {
            System.out.println("0 - Sair");

            System.out.println("1 - Inserir 1 valor na ABB");

            System.out.println("2 - Apresentar ABB (em ordem)");

            System.out.println("3 - Conta quantidade de nos da ABB");

            System.out.println("4 - Consulta a existencia de um valor na ABB");

            System.out.print("Opcao: ");

            opcao = le.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Fechando a execucao");

                    break;

                case 1:
                    System.out.print("Informe valor a ser inserido: ");

                    int valor = le.nextInt();

                    abb.root = abb.inserir(abb.root, valor);

                    break;

                case 2:
                    System.out.println("\t Apresentacao da ABB");

                    abb.show(abb.root);

                    System.out.println();

                    break;

                case 3:
                    System.out.println("Quantidade de nos na ABB: " + abb.contaNos(abb.root, 0));

                    break;

                case 4:
                    System.out.println("Informe o valor a ser pesquisado: ");

                    valor = le.nextInt();

                    if (abb.consulta(abb.root, valor)) {
                        System.out.println("Valor encontrado na ABB");
                    } else {

                        System.out.println("Valor não encontrado na ABB");
                    }

                case 5:
                    System.out.println("Informe o valor a ser pesquisado: ");

                    valor = le.nextInt();

                    System.out.println("Quantidade de comparações: " + abb.contaConsulta(abb.root, valor, 0));

                    break

                case 6:
                    System.out.println("Informe o valor a ser removido: ");

                    valor = le.nextInt();

                    abb.root = abb.removeValor(abb.root, valor);

                    break;
                case 7:
                    if (abb.root != null) {
                        System.out.println("Maior valor = " + abb.maximo());
                    }

                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (opcao != 0);
        le.close();

    }

}