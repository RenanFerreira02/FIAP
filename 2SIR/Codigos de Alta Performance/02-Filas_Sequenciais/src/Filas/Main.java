package Filas;

public class Main {
    public static void main(String[] args) {
        FilaInt queue = new FilaInt();

        queue.init();

        queue.enqueue(17);

        queue.enqueue(23);

        queue.enqueue(66);

        queue.enqueue(99);

        if (!queue.isEmpty()) {
            System.out.println("Valor retirado da fila: " + queue.dequeue());
        } else {
            System.out.println("Queue is empty");
        }

        if (!queue.isEmpty()) {
            System.out.println("Valor retirado da fila: " + queue.dequeue());
        } else {
            System.out.println("Queue is empty");
        }
    }
}
