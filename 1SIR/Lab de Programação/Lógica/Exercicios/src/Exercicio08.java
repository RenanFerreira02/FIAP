import java.util.Scanner;

public class Exercicio08 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int num, dezena;

        System.out.print("Digite o número de três digitos: ");
        num = input.nextInt();

        dezena = (num / 10) % 10;

        System.out.println("A dezena é " + dezena);
    }
}
