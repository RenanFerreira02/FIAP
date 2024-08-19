import java.util.Random;

public class Exercicio08 {
    public static void main(String[] args) {
        Random r = new Random();

        int v[] = new int[10];

        boolean status;

        for (int i = 0; i < v.length;) {
            v[i] = r.nextInt(15);

            status = true;

            for (int j = 0; j < i; j++) {
                if (v[i] == v[j]) {
                    status = false;

                    break;
                }

            }

            if (status) {
                System.out.print(v[i] + " ");
                i++;
            }
        }
    }
}
