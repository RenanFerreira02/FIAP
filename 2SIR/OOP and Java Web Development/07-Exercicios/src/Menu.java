import java.text.DecimalFormat;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;
import static javax.swing.JOptionPane.*;

public class Menu {

    private Fornecedor[] fornecedor = new Fornecedor[5];

    private Produto[] produto = new Produto[5];

    private int indexP = 0;

    private int indexF = 0;

    public void menu() {
        String aux = "Escolha uma opção\n" + "1 - Cadastrar Produtos\n" + "2 - Pesquisar produto por nome\n" + "3 - Pesquisar produto por CNPJ\n" + "4 - Finalizar\n";

        int opc;
        int resposta;

        while (true) {
            opc = parseInt(showInputDialog(aux));

            if (opc == 4) {
                resposta = showConfirmDialog(null, "Deseja finalizar o programa?");

                if (resposta == YES_OPTION) {
                    break;
                }
            }

            if (opc < 1 || opc > 4) {
                showMessageDialog(null, "Opção Inválida");
            } else {
                switch (opc) {
                    case 1:
                        cadastrarProduto();
                        break;

                    case 2:
                        pesquisarProduto();
                        break;

                    case 3:
                        pesquisarCNPJ();
                        break;
                }
            }
        }
    }

    private Fornecedor verificaCnpj() {
        long cnpj = parseLong(showInputDialog("CNPJ do Fornecedor: "));

        for (int i = 0; i < indexF; i++) {
            if (cnpj == fornecedor[i].getCnpj()) {
                return fornecedor[i];
            }
        }
        showMessageDialog(null, "CNPJ: " + cnpj + " Não encontrado");

        return null;

    }

    private void cadastrarProduto() {
        String nome;
        double valor;
        int qtdEstoque;

        Fornecedor fornecedor = verificaCnpj();

        if (fornecedor == null) {
            fornecedor = cadastrarFornecedor();
        }

        nome = showInputDialog("Nome do Produto: ");

        valor = parseDouble(showInputDialog("Valor do Produto: "));

        qtdEstoque = parseInt(showInputDialog("Quantidade de Estoque: "));

        produto[indexP] = new Produto(nome, valor, qtdEstoque, fornecedor);

        indexP++;

    }

    private Fornecedor cadastrarFornecedor() {
        String nome;

        long cnpj;

        Fornecedor f = null;

        if (indexF < fornecedor.length) {
            nome = showInputDialog("Nome do Fornecedor: ");

            cnpj = parseLong(showInputDialog("CNPJ do Fornecedor: "));

            fornecedor[indexF] = new Fornecedor(nome, cnpj);

            f = fornecedor[indexF];

            indexF++;
        }

        return f;

    }


    public void pesquisarProduto() {
        String nome = showInputDialog("Nome do Produto: ");

        String aux = "";

        DecimalFormat df = new DecimalFormat("#.00");

        for (int i = 0; i < indexP; i++) {
            if (produto[i].getNome().equalsIgnoreCase(nome)) {
                aux = "Nome do produto: " + nome + "\n";
                aux += "Valor do produto: " + df.format(produto[i].getValor()) + "\n";
                aux += "Quantidade em estoque: " + produto[i].getQuantidade() + "\n";
                aux += "Fornecedor: " + produto[i].getFornecedor().getNome() + "\n";

                break;
            }
        }

        showMessageDialog(null, "Produto não encontrado");
    }

    public void pesquisarCNPJ() {
        Fornecedor fornecedor = verificaCnpj();

        if (fornecedor != null) {
            String aux = "Nome do produto: " + fornecedor.getNome() + "\n";
            aux += "CNPJ: " + fornecedor.getCnpj() + "\n";

            showMessageDialog(null, aux);
        }

    }
}
