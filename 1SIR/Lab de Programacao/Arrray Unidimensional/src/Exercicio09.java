import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat mascara = new DecimalFormat("#,##0.00");

        int qtdFuncionario;
        double folhaDePagamento = 0;

        System.out.print("Digite a quantidade de funcionários: ");
        qtdFuncionario = input.nextInt();

        String funcionario[] = new String[qtdFuncionario];
        double salario[] = new double[funcionario.length];

        for (int i = 0; i < funcionario.length; i++) {
            input.nextLine();

            System.out.print("\nNome: ");
            funcionario[i] = input.nextLine();

            System.out.print("Salario: ");
            salario[i] = input.nextDouble();

            folhaDePagamento += salario[i];

        }

        System.out.println("\nTotal de folha de pagamento: R$ " + mascara.format(folhaDePagamento));

        System.out.println("\nMedia salarial: R$ " + mascara.format(folhaDePagamento / qtdFuncionario));

        input.close();
    }

}
