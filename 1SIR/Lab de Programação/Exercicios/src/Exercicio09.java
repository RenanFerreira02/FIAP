import java.util.Scanner;

public class Exercicio09 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num, numInv, centena, dezena, unidade;

        System.out.print("Digite um número com 3 dígitos: ");
        num = input.nextInt();

        centena = num / 100;
        dezena = num % 100 / 10;
        unidade = num % 10;

        numInv = unidade * 100 + dezena * 10 + centena;

        System.out.println(num + " --> " + numInv);
    }
}
