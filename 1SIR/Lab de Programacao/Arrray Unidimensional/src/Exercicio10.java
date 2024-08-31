import java.util.Random;

public class Exercicio10 {

    public static void main(String[] args) {
        Random r = new Random();

        int v[] = new int[r.nextInt(2, 11)];
        int temp;

        // Gerando os números aleatórios

        System.out.println("Antes da ordenação: ");

        for (int i = 0; i < v.length; i++) {
            v[i] = r.nextInt() % 10;

            System.out.print(v[i] + " ");
        }

        // Organizando os números em ordem crescente

        for (int j = 0; j < v.length; j++) {
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    temp = v[i];

                    v[i] = v[i + 1];

                    v[i + 1] = temp;
                }
            }
        }

        // Imprimindo os números na ordem correta

        System.out.println("\nDepois da ordenação: ");
        for (int i : v) {
            System.out.print(i + " ");
        }
    }
}