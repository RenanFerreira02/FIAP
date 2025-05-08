public class Main {
    public static void main(String[] args) {
        Node list = new Node();

        list.data = 1;

        list.next = null;

        Node list2 = new Node();

        list2.data = 2;

        list2.next = null;

        list.next = list2;

        System.out.println("Lista: " + list + "\tDado: " + list.data + "\tProximo: " + list.next);

        System.out.println("Lista: " + list2 + "\tDado: " + list2.data + "\tProximo: " + list2.next);

        Node list3 = new Node();

        list3.data = 3;

        list2.next = list;

        System.out.println("\n\n Após inserção do terceiro elemento");

        System.out.println("Lista: " + list3 + "\tDado: " + list3.data + "\tProximo: " + list3.next);

        System.out.println("Lista: " + list + "\tDado: " + list.data + "\tProximo: " + list.next);

        System.out.println("Lista: " + list2 + "\tDado: " + list2.data + "\tProximo: " + list2.next);

        System.out.println("\n\nApresentando todos os nodes da lista");

        list = list3;

        Node aux = list;

        while (aux != null) {
            System.out.println(aux.data);

            aux = aux.next;
        }
    }
}
