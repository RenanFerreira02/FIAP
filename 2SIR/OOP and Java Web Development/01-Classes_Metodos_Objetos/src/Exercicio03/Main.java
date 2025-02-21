package Exercicio03;

public class Main {
    public static void main(String[] args) {
        Conta conta = new Conta();

        conta.depositar(150);

        conta.sacar(50);

        System.out.println(conta.consultaSaldo());
    }
}
