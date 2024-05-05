import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int x, y, z, t;

        System.out.print("Digite o valor de X: ");
        x = input.nextInt();

        System.out.print("Digite o valor de Y: ");
        y = input.nextInt();

        System.out.print("Digite o valor de Z: ");
        z = input.nextInt();

        if (x > y) {
            t = x;
            x = y;
            y = t;
        }

        if (x > z) {
            t = x;
            x = z;
            z = t;

        }

        if (y > z) {
            t = y;
            y = z;
            z = t;

        }

        System.out.println("Primeiro: " + x);
        System.out.println("Segundo: " + y);
        System.out.println("Terceiro: " + z);

        input.close();
    }

}
