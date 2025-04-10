package Filas;

public class FilaInt {
    final int N = 3;

    int[] data = new int[N];

    int start, end, cont;


    public void init() {
        start = end = cont = 0;
    }

    public boolean isEmpty() {
        return (cont == 0);
    }

    public boolean isFull() {
        return (cont == N);
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            data[end] = value;

            cont++;

            end = (end + 1) % N;
        }
    }

    public int dequeue() {
        int aux = data[start];

        cont--;

        start = (start + 1) % N;

        return aux;
    }


}
