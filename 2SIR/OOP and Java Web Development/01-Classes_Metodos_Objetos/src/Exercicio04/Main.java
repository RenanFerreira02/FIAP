package Exercicio04;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");

        Scanner sc = new Scanner(System.in);

        Professor p1 = new Professor();
        Professor p2 = new Professor();
        Professor p3 = new Professor();

        System.out.print("Nome do professor 1: ");
        p1.nome = sc.next();
        System.out.print("Total de aulas semanais do professor 1: ");
        p1.totalAulas = sc.nextInt();
        System.out.print("Valor da hora aula do professor 1: R$ ");
        p1.valorHoraAula = sc.nextDouble();

        System.out.print("Nome do professor 2: ");
        p2.nome = sc.next();
        System.out.print("Total de aulas semanais do professor 2: ");
        p2.totalAulas = sc.nextInt();
        System.out.print("Valor da hora aula do professor 2: R$ ");
        p2.valorHoraAula = sc.nextDouble();

        System.out.print("Nome do professor 3: ");
        p3.nome = sc.next();
        System.out.print("Total de aulas semanais do professor 3: ");
        p3.totalAulas = sc.nextInt();
        System.out.print("Valor da hora aula do professor 3: R$ ");
        p3.valorHoraAula = sc.nextDouble();

        // saída de dados
        System.out.println();
        System.out.println("Nome do professor: " + p1.nome);
        System.out.println("Salário Bruto: R$ " + df.format(p1.calcularSalario()));

        System.out.println();
        System.out.println("Nome do professor: " + p2.nome);
        System.out.println("Salário Bruto: R$ " + df.format(p2.calcularSalario()));

        System.out.println();
        System.out.println("Nome do professor: " + p3.nome);
        System.out.println("Salário Bruto: R$ " + df.format(p3.calcularSalario()));
    }
}
