import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a, b, c, delta, x1, x2, x;

        System.out.println("Digite os coeficientes da equação ax^2 + bx + c:");

        System.out.print("a: ");
        a = input.nextDouble();

        System.out.print("b: ");

        b = input.nextDouble();

        System.out.print("c: ");
        c = input.nextDouble();

        delta = b * b - 4 * a * c;

        if (delta > 0) {
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("As raízes da equação são x1 = " + x1 + " e x2 = " + x2);

        } else if (delta == 0) {
            x = -b / (2 * a);
            System.out.println("A equação tem apenas uma raiz real: x = " + x);

        } else {
            System.out.println("A equação não possui raízes reais.");

        }

        input.close();
    }
}
