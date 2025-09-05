package Exercicio01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Candidato> lista = new ArrayList<>();

        lista.add(new Candidato("A", 6.5, 15));

        lista.add(new Candidato("B", 9.9, 5));

        lista.add(new Candidato("C", 5.3, 1));

        lista.add(new Candidato("D", 9.9, 20));

        Comparator<Candidato> criterio = Comparator.comparing(Candidato::getNotaTecnica).thenComparing(Candidato::getAnosExperiencia).reversed().thenComparing(Candidato::getNome);

        lista.sort(criterio);

        lista.forEach(candidato -> {
            System.out.println(candidato.toString());
        });
    }
}
