import java.util.Scanner;

public class MainTeste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListaIntCrescente lista = new ListaIntCrescente();

        System.out.println("Valor positivo insere (negativo encerra): ");

        int valor = sc.nextInt();

        while (valor >= 0) {
            lista.insere(valor);

            lista.mostra();

            System.out.println("Valor positivo insere (negativo encerra): ");

            valor = sc.nextInt();
        }

        sc.close();
    }
}