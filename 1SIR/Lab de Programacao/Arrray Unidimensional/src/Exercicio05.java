import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numeros = new int[4];
        int temp;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            numeros[i] = input.nextInt();

        }

        for (int i = 0; i < numeros.length / 2; i++) {
            temp = numeros[i];

            numeros[i] = numeros[numeros.length - 1 - i];

            numeros[numeros.length - 1 - i] = temp;
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        int j = numeros.length - 1;

        for (int i = 0; i <= j; i++) {
            temp = numeros[i];

            numeros[i] = numeros[numeros.length - 1 - i];

            numeros[numeros.length - 1 - i] = temp;
        }

        input.close();
    }
}
