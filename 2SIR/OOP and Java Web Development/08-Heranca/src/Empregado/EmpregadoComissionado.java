package Empregado;

import java.text.DecimalFormat;

public class EmpregadoComissionado extends Empregado {
    double totalDeVendas;
    double comissao;

    public EmpregadoComissionado(long matricula, String nome, double totalDeVendas, double comissao) {
        super(matricula, nome);
        this.totalDeVendas = totalDeVendas;
        this.comissao = comissao;
    }

    public double calcularSalario() {
        return totalDeVendas * comissao /100;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");

        String aux = super.toString();
        aux += "Salario: " + df.format(totalDeVendas) + "\n";
        aux += "Comissao: " + df.format(comissao) + "%\n";

        return aux;
    }
}
