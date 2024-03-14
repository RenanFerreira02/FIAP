import java.util.Scanner;

public class Exercicio01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double base, altura, area, perimetro;
		
		System.out.println("Calcule a Área e o Perímetro de um retângulo\n");
		
		System.out.print("Digite o valor da base (em cm) ");
		base = input.nextDouble();
		
		System.out.print("Digite o valor da altura (em cm) ");
		altura = input.nextDouble();
		
		area = base * altura;
		
		perimetro = (base + altura) * 2;
		
		System.out.println("A área é " + area + " e o perímetro é " + perimetro);
		
		
		

	}

}
