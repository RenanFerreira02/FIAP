package Pilhas;

public class Main {
    public static void main(String[] args) {
        PilhaInt pilha = new PilhaInt();

        pilha.init();

        pilha.push(10);

        pilha.push(12);

        pilha.push(22);

        pilha.push(33);

        pilha.push(44);

        pilha.push(55);

        pilha.push(66);

        if (pilha.isEmpty()) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("O topo da pilha é: " + pilha.top());
        }

        if (pilha.isEmpty()) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("Valor retirado da pilha: " + pilha.pop());
        }

        if (pilha.isEmpty()) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("O topo da pilha é: " + pilha.top());
        }

        System.out.println("Apresentação dos dados empilhados");

        pilha.esvazia();
    }
}
