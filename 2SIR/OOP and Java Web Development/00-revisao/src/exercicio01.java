import java.util.Scanner;

public class exercicio01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;

        System.out.print("Insira um número inteiro: ");
        n = input.nextInt();

        System.out.print(n + " ");

        while (n != 1) {

            if (n % 2 == 1) {
                n = n * 3 + 1;
            } else {
                n = n / 2;
            }

            System.out.print(n + " ");
        }

        input.close();
    }
}