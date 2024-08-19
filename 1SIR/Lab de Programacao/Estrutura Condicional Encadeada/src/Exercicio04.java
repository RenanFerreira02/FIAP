import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int valor1, valor2, valor3, menor;

        System.out.println("Digite três valores inteiros:");
        valor1 = input.nextInt();
        valor2 = input.nextInt();
        valor3 = input.nextInt();

        if (valor1 != valor2 && valor1 != valor3 && valor2 != valor3) {
            menor = valor1;
            if (valor2 < menor) {
                menor = valor2;
            }
            if (valor3 < menor) {
                menor = valor3;
            }
            System.out.println("O menor valor é: " + menor);
        } else {
            System.out.println("Os valores não são todos diferentes entre si.");
        }

        input.close();

    }
}
