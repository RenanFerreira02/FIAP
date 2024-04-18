import java.util.Scanner;

public class Exercicio03 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double tempo, velocidade;
		
		double distancia, litros;
		
		System.out.println("Informe o tempo da viagem ");
		tempo = input.nextDouble();
		
		System.out.println("Informe a velocidade média ");
		velocidade = input.nextDouble();
		
		distancia = velocidade * tempo;
		
		litros = distancia / 10.5;
		
		System.out.println("distância percorrida = " + distancia);
		
		System.out.println("total de litros = " + litros);
		
	}
}
