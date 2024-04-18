import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio04 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		DecimalFormat maskType = new DecimalFormat("#.##");
		
		// DecimalFormat maskType2 = new DecimalFormat("0.00");
		
		double salarioMinimo, qtdKw, valorDoKw, valorTotal, valorComDesconto;
		
		System.out.print("Valor do salário mínimo: ");
		salarioMinimo = input.nextDouble();
		
		System.out.print("Quantidade de quilowatts consumida: ");
		qtdKw = input.nextDouble();
		
		valorDoKw = salarioMinimo / 7 / 100;
		
		valorTotal = valorDoKw * qtdKw;
		
		valorComDesconto = valorTotal * 0.9;
		
		System.out.println("\nValor do quilowatt: R$ " + maskType.format(valorDoKw));
		
		System.out.println("Valor total: R$ " + maskType.format(valorComDesconto));
		
		System.out.println("Valor total com desconto: R$ " + maskType.format(valorComDesconto));
	}

}
