package Exercicio04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Funcionario f;

        String nome;
        String cargo;
        double salario;

        double porcentagem;

        // Entrada de dados e instanciação do funcionário

        System.out.print("Nome: ");
        nome = sc.next();

        System.out.print("Cargo: ");
        cargo = sc.next();

        System.out.print("Salario: ");
        salario = sc.nextDouble();

        f = new Funcionario(nome, cargo, salario);

        System.out.println("Salário R$ " + f.salario);

        // Aumento de salário de acordo com uma porcentagem
        System.out.print("\nPorcentagem de aumento de salário: ");
        porcentagem = sc.nextDouble();

        f.aumentarSalario(porcentagem);

        System.out.println("Novo Salário R$ " + f.salario);
    }

}
