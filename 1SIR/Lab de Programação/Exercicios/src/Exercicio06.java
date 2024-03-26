import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DecimalFormat mask = new DecimalFormat("#.###");

        double y, cbrtRes, cbrtNumber, x;

        System.out.print("Digite o número de X: ");
        x = input.nextDouble();

        cbrtNumber = x -  1.0 / 2.0;

        cbrtRes = Math.cbrt(cbrtNumber);

        y = Math.sqrt(cbrtRes);

        System.out.println("O resultado é " + mask.format(y));

    }
}
