import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int vetor[] = new int[10];
        int impar = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Valor: ");
            vetor[i] = input.nextInt();

            if (vetor[i] % 2 != 0) {
                impar++;
            }
        }

        System.out.println("Total Ímpar: " + impar);
        System.out.println("Total Par: " + (vetor.length - impar));

        input.close();
    }
}