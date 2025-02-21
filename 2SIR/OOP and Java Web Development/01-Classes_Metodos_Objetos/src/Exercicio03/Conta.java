package Exercicio03;

public class Conta {

    //Variáveis de instância
    int numConta;
    int agencia;
    double saldo;


    //Método para sacar um valor
    public void sacar(double valor) {
        saldo -= valor;
    }

    //Método para depositar
    public void depositar(double valor) {
        saldo += valor;
    }

    //Método para retornar o valor do saldo
    public double consultaSaldo() {
        return saldo;
    }
}
