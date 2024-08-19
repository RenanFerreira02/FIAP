import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int qntdElementos;
        boolean status = true;

        System.out.print("Digite a quantidade de elementos do array: ");
        qntdElementos = input.nextInt();

        int array[] = new int[qntdElementos];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Valor: ");
            array[i] = input.nextInt();
        }

        if (qntdElementos != 1) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] % 2 == array[i + 1] % 2) {
                    status = false;
                    break;
                }
            }

            if (status) {
                System.out.println("Vetor especial");
            } else {
                System.out.println("Vetor não especial");
            }
        }

        input.close();
    }
}
