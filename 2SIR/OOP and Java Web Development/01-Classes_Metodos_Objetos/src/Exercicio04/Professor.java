package Exercicio04;

public class Professor {
    String nome;
    int totalAulas;
    double valorHoraAula;

    public double calcularSalario() {
        double salario, salarioBase, horaAtividade, descanso;

        salarioBase = totalAulas * 4.5 * valorHoraAula;
        horaAtividade = salarioBase * 5 / 100;
        descanso = (salarioBase + horaAtividade) / 6;
        salario = salarioBase + horaAtividade + descanso;

        return salario;
    }
}
