public class FilaInt {


    private class Node {
        int data;

        Node next;
    }

    private Node ini, fim;

    public void init() {
        ini = fim = null;
    }

    public boolean isEmpty() {
        return (ini == null && fim == null);
    }

    public void enqueue(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if(isEmpty()) {
            ini = newNode;
        } else {
            fim.next = newNode;
        }

        fim = newNode;
    }

    public int dequeue() {
        int valor = ini.data;

        ini = ini.next;

        if(ini == null) {
            fim = null;
        }

        return valor;
    }
}
