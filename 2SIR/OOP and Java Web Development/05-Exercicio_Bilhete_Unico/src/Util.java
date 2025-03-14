import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

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
                }
            }


        }

    }

    public void emitirBilhete() {
        String nome = showInputDialog("Nome: ");

        long cpf = parseLong(showInputDialog("CPF: "));

        String perfil = showInputDialog("Perfil(comum, estudante ou professor): ");

        bilhete[index] = new Bilhete(new Usuario(nome, cpf, perfil));

    }
}
