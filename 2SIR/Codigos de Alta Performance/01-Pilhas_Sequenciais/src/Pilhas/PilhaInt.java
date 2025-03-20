package Pilhas;

public class PilhaInt {
    final int n = 6;

    int[] dados = new int[n];

    int topo;


    public void init() {
        topo = 0;
    }

    public void push(int elemento) {
        dados[topo] = elemento;
        topo++;
    }

    public int pop() {
        topo--;
        return dados[topo];
    }
}
