import java.util.Scanner;

public class Exercicio10 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int binario, decimal, milhar, centena, dezena, unidade;

        System.out.print("Digite o número binário com 4 dígitos: ");
        binario = input.nextInt();

        milhar = binario / 1000 * 8;
        centena = binario / 100 % 10 * 4;
        dezena = binario % 10 / 10 * 2;
        unidade = binario % 10 * 1;

        decimal = milhar + centena + dezena + unidade;

        System.out.println(binario + " --> " + decimal);
    }
}
