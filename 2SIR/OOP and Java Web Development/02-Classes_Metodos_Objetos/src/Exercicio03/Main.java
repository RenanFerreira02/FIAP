package Exercicio03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        Ponto p1 = new Ponto();
        Ponto p2 = new Ponto();

        // Entrada de dados
        System.out.println("Informe as coordenadas do ponto 1: ");
        p1.x = sc.nextInt();
        p1.y = sc.nextInt();

        System.out.println("Informe as coordenadas do ponto 2: ");
        p2.x = sc.nextInt();
        p2.y = sc.nextInt();


        // Impressão da distância entre os dois pontos
        System.out.println();

        System.out.println("Distância do p1 para o p2: " + df.format(p1.calcularDistancia(p2)));

        System.out.println("Distância do p2 para o p1: " + df.format(p2.calcularDistancia(p1)));

        // Impressão da distância de cada ponto até a origem
        System.out.println();

        System.out.println("Distância do p1 para a origem: " + df.format(p1.calcularDistanciaAteOrigem()));

        System.out.println("Distância do p2 para a origem: " + df.format(p2.calcularDistanciaAteOrigem()));


        // Impressão do ponto mais próximo da origem
        Ponto aux = p1.maisProximoDaOrigem(p1, p2);

        System.out.println("Ponto mais proximo: " + aux.formatarPonto());

    }
}
