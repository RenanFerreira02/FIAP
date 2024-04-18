import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        DecimalFormat decimal = new DecimalFormat("#.##");

        double y, x;

        System.out.print("Digite o valor de X: ");
        x = input.nextDouble();

        // Exemplo com operador OU

        if( x < -5 || x > 5 ) {
            y = 8 / Math.sqrt(Math.pow(x, 2) - 25);

            System.out.println("O valor é " + decimal.format(y));
        } else {
            System.out.println("Digite um valor válido!");
        }

        // Exemplo com operador E

        // if (x >= -5 && x <= 5) {
        //     System.out.println("Digite um valor válido!");
            
        // } else {
        //     y = 8 / Math.sqrt(Math.pow(x, 2) - 25);
        //     System.out.println("O valor é " + y);
        // }
        
    }
    
}
