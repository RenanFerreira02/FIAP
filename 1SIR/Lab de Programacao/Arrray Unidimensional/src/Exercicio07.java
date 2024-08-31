import java.util.Random;

public class Exercicio07 {
    public static void main(String[] args) {
        Random rd = new Random();

        int v[] = new int[10];
        int maior = 0, total;

        for (int i = 0; i < v.length; i++) {
            v[i] = rd.nextInt(15);

            System.out.print(v[i] + " ");
        }

        for (int i = 0; i < v.length; i++) {
            total = 0;

            for (int j = 0; j < v.length; j++) {
                if (v[i] == v[j]) {
                    total++;
                }
            }

            if (total > maior) {
                maior = total;
            }
        }

        System.out.println("Frequencia: " + maior);
    }
}
