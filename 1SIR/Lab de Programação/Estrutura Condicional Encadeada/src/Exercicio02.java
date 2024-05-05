import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double diaria, txServicos, total;
        int numDiarias;

        diaria = 250.00;

        System.out.println("Digite o número de diárias: ");
        numDiarias = input.nextInt();

        if (numDiarias > 15) {
            txServicos = 15.50 * numDiarias;

            total = diaria + txServicos;

            System.out.println("O valor final a ser pago será de: " + total);
        } else if (numDiarias == 15) {
            txServicos = 36.00 * numDiarias;

            total = diaria + txServicos;

            System.out.println("O valor final a ser pago será de: " + total);
        } else if (numDiarias < 15) {
            txServicos = 58.00 * numDiarias;

            total = diaria + txServicos;

            System.out.println("O valor final a ser pago será de: " + total);
        }

        input.close();
    }
}
