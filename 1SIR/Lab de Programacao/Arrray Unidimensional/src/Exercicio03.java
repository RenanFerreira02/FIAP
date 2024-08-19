import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double media[] = new double[4];
        double nota1, nota2, nota3, nota4;
        double total = 0;

        for (int i = 0; i < media.length; i++) {
            System.out.println("ALUNO " + (i + 1));

            System.out.print("Nota 1: ");
            nota1 = input.nextDouble();

            System.out.print("Nota 2: ");
            nota2 = input.nextDouble();

            System.out.print("Nota 3: ");
            nota3 = input.nextDouble();

            System.out.print("Nota 4: ");
            nota4 = input.nextDouble();

            media[i] = (nota1 + nota2 + nota3 + nota4) / 4;

            if (media[i] > 6.0) {
                total++;
            }
        }

        System.out.println("Total de alunos aprovados: " + total);

        input.close();

    }
}
