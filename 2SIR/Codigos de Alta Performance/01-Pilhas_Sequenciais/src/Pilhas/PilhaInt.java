package Pilhas;

public class PilhaInt {
    final int n = 6;

    int[] dados = new int[n];

    int topo;


    public void init() {
        topo = 0;
    }

    public void push(int elemento) {
        if (isFull()) {
            System.out.println("Stack Overflow");
        } else {
            dados[topo] = elemento;
            topo++;
        }
    }

    public int pop() {
        topo--;
        return dados[topo];
    }

    public boolean isFull() {
        return (topo == n);
    }

    public boolean isEmpty() {
        return (topo == 0);
    }

    public int top() {
        return dados[topo - 1];
    }

    public void esvazia() {
        while(!isEmpty()) {
            System.out.print(" " + pop());
        }
    }


}
