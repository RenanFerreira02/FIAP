package Forma;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Forma> lista = new ArrayList<Forma>();

        lista.add(new Cilindro(1, 1, 1, 1));

        lista.add(new Circulo(2, 2, 2));

        lista.add(new Cilindro(3, 3, 3, 3));

        /*for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
            System.out.println("---------------------------");
        }*/

        for (Forma forma : lista) {
            System.out.println(forma.getClass().getSimpleName());

            System.out.println(forma);

            System.out.println("Área = " + forma.calcularArea());

            if (forma instanceof Volume) {
                System.out.println("Volume = " + ((Volume) forma).calcularVolume());
            }

            System.out.println("---------------------------");


        }

    }
}
