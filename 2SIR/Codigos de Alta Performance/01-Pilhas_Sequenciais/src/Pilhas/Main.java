package Pilhas;

public class Main {
    public static void main(String[] args) {
        PilhaInt pilha = new PilhaInt();

        pilha.init();

        pilha.push(10);

        pilha.push(12);

        System.out.println("Valor retirado da pilha: " + pilha.pop());

        System.out.println("Valor retirado da pilha: " + pilha.pop());

    }
}
