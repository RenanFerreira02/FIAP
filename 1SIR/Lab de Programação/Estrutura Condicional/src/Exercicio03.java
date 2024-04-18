import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        double valorTotal, valorDesconto, valorFinal;

        System.out.print("Infome o valor total das compras R$ ");
        valorTotal = input.nextDouble();

        if (valorTotal > 1000) {
            valorDesconto = valorTotal * 0.15;

            valorFinal = valorTotal - valorDesconto;
        }else {
            valorDesconto = valorTotal * 0.08;

            valorFinal = valorTotal - valorDesconto;
        }

        System.out.println("\nValor final a pagar: " + valorFinal);
        System.out.println("Total do desconto: " + valorDesconto);
    }
}
