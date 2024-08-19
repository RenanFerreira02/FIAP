import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double p1, p2, t1, t2, t3, mf;
        double tolerancia = 0.0000000001;

        System.out.print("Digite a nota da primeira prova: ");
        p1 = input.nextDouble();

        System.out.print("Digite a nota da segunda prova: ");
        p2 = input.nextDouble();

        System.out.print("Digite a nota do primeiro trabalho: ");
        t1 = input.nextDouble();

        System.out.print("Digite a nota do segundo trabalho: ");
        t2 = input.nextDouble();

        System.out.print("Digite a nota do terceiro trabalho: ");
        t3 = input.nextDouble();

        mf = 0.7 * (p1 + p2) / 2 + 0.30 * (t1 + t2 + t3) / 3;

        if(mf >= 6 - tolerancia) {
            System.out.println("Aprovado!");
        } else {
            System.out.println("Reprovado!");
        }
    }
}
