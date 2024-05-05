import java.util.Scanner;

public class Exemplo {
    public static void main(String[] args) {
        int num1, num2;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite o primeiro número:");
        num1 = input.nextInt();

        System.out.print("Digite o segundo número:");
        num2 = input.nextInt();

        while (num1 >= num2) {
            System.out.println("\nO segundo número não pode ser menor que o primeiro!");
            System.out.print("\nDigite o segundo número:");
            num2 = input.nextInt();
        }

        do {
            if (num1 % 2 == 1) {
                System.out.println(num1);
            }

            num1++;

        } while (num1 <= num2);

        input.close();
    }
}
