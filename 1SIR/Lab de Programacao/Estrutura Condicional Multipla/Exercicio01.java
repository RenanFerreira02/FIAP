import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String letra;

        System.out.println("Digite uma letra: ");
        letra = input.next();

        letra = letra.toLowerCase();

        if (letra.equals('a') || letra.equals('e') || letra.equals('i') || letra.equals('o') || letra.equals('u')) {
            System.out.println("É vogal");
        } else {
            System.out.println("Não é vogal");
        }
    }
}
