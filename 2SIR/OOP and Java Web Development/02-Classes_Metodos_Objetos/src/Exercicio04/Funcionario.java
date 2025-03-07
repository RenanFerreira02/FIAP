package Exercicio04;

public class Funcionario {

    // Variáveis de instância
    String nome;
    String cargo;
    double salario;

    // Método construtor
    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }


    // Método para aplicar aumento com base em uma porcentagem
    public void aumentarSalario(double percentual) {
        salario += salario * (percentual / 100);
    }

    // Método para aplicar aumento com base em um cargo e uma porcentagem
    public void aumentarSalario(String cargo, double percentual) {

        if (cargo.equalsIgnoreCase(this.cargo)) {
            salario += salario * (percentual / 100);
        }
    }

    // Método para promover o funcionário
    public void promocao(String novoCargo) {
        cargo = novoCargo;
    }
}
