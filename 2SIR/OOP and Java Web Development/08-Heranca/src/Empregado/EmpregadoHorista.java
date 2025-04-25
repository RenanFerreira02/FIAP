package Empregado;

import java.text.DecimalFormat;

public class EmpregadoHorista extends Empregado {
    int totalDeHorasTrabalhadas;
    double valorDaHoraTrabalhada;

    public EmpregadoHorista(long matricula, String nome, int totalDeHorasTrabalhadas, double valorDaHoraTrabalhada) {
        super(matricula, nome);
        this.totalDeHorasTrabalhadas = totalDeHorasTrabalhadas;
        this.valorDaHoraTrabalhada = valorDaHoraTrabalhada;
    }

    public double calcularSalario() {
        return totalDeHorasTrabalhadas * valorDaHoraTrabalhada;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");

        String aux = super.toString();
        aux += "Total de horas Trabalhadas: " + df.format(totalDeHorasTrabalhadas) + "\n";
        aux += "Valor da hora: " + df.format(valorDaHoraTrabalhada) + "%\n";

        return aux;
    }
}

