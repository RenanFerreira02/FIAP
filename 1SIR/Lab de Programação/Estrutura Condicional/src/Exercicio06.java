import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double l1,l2,l3;

        System.out.print("Primeiro lado: ");
        l1 = input.nextDouble();

        System.out.print("Segundo lado: ");
        l2 = input.nextDouble();

        System.out.print("Terceiro lado: ");
        l3 = input.nextDouble();

        // Operador lógico E

        if (l1 < l2 + l3 && l2 < l1 + l3 && l3 < l1 + l2) {
            System.out.println("É um triângulo");

            if (l1 == l2 && l1 == l3) {
                System.out.println("O triângulo é equilatero");
            } else if (l1 == l2 || l1 == l3 || l2 == l3) {
                System.out.println("O triângulo é isóceles");
            } else {
                System.out.println("O triângulo é escaleno");
            }

        } else {
            System.out.println("Não é um triângulo");
        }

        // Operador lógico OU

        // if (l1 >= l2 + l3 || l2 >= l1 + l3 || l3 >= l1 + l2) {
        //     System.out.println("É um triângulo");
        // } else {
        //     System.out.println("Não é um triângulo");
        // }
    }
    
}
