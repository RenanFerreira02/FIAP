import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {
    private Bilhete[] bilhete = new Bilhete[5];

    private int index = 0;

    public void menu() {
        String aux = "Escolha uma opção\n";
        aux += "1 - Emitir Bilhete\n";
        aux += "2 - Carregar Bilhete\n";
        aux += "3 - Consultar Saldo\n";
        aux += "4 - Passar na catraca\n";
        aux += "5 - Finalizar\n";

        int opc;

        /*
        String aux = """
                Escolha uma opção
             1- Emitir Bilhete
             2- Carregar Bilhete
             3- Consultar Saldo
             4- Passar na catraca
             5- Finalizar
                """;
         */

        while (true) {
            opc = parseInt(showInputDialog(aux));

            if (opc == 5) {
                break;
            }

            if (opc < 1 || opc > 5) {
                showMessageDialog(null, "Opção Inválida");
            } else {
                switch (opc) {
                    case 1:
                        emitirBilhete();
                        break;

                    case 2:
                        carregaBilhete();
                        break;

                    case 3:
                        consultaSaldo();
                        break;

                    case 4:
                        passarNaCatraca();
                        break;


                }
            }


        }

    }

    public void emitirBilhete() {

        if (index < bilhete.length) {
            String nome = showInputDialog("Nome: ");

            long cpf = parseLong(showInputDialog("CPF: "));

            String perfil = showInputDialog("Perfil(comum, estudante ou professor): ");

            bilhete[index] = new Bilhete(new Usuario(nome, cpf, perfil));

            index++;
        } else {
            showMessageDialog(null, "Bilhete não emitido!");
        }
    }

    public int pesquisaCPF() {
        long cpf = parseLong(showInputDialog("CPF para pesquisa: "));

        for (int i = 0; i < index; i++) {
            if (bilhete[i].usuario.cpf == cpf) {
                return i;
            }
        }
        return -1;
    }

    public void carregaBilhete() {
        int posicao = pesquisaCPF();

        double valor;

        if (posicao == -1) {
            showMessageDialog(null, "CPF não encontrado!");
        } else {
            valor = parseDouble(showInputDialog("Valor para recarga: "));

            bilhete[posicao].carregar(valor);
        }
    }

    public void consultaSaldo() {
        int posicao = pesquisaCPF();

        if (posicao == -1) {
            showMessageDialog(null, "CPF não encontrado!");
        } else {
            showMessageDialog(null, "Saldo: " + bilhete[posicao].consultarSaldo());

        }
    }

    public void passarNaCatraca() {
        int posicao = pesquisaCPF();

        if (posicao == -1) {
            showMessageDialog(null, "CPF não encontrado!");
        } else {
            showMessageDialog(null, bilhete[posicao].passarCatraca());
        }

    }


}
