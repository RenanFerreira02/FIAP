import java.util.Scanner;

public class Exercicio02 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double tc, tf;
		
		System.out.print("Informe a temperatura em celsius: ");
		tc = input.nextDouble();
		
		tf = tc * 9 / 5 + 32;
		
		System.out.println("temperatura fahrenheit = " + tf);

	}
}
