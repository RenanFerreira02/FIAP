import java.util.Scanner;

public class exercicio02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int i, j;

        System.out.print("Insira um número inteiro: ");
        i = input.nextInt();

        System.out.print("Insira um número inteiro: ");
        j = input.nextInt();

        int maior = calcular(i, j);

        System.out.println("Maior número de impressões = " + maior);

        input.close();
    }

    public static int calcular(int i, int j) {
        int cont, n, maior = 0;

        while (i <= j) {
            cont = 0;
            n = i;

            while (true) {
                cont++;

                if(n == 1){
                    break;
                }

                if (n % 2 == 1) {
                    n = n * 3 + 1;
                } else {
                    n = n / 2;
                }

            }
            if (cont > maior) {
                maior = cont;
            }
            i++;
        }
        return maior;

    }

}