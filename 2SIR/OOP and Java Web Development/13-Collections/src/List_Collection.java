import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class List_Collection {
    public static void main(String[] args) {

        List<Aluno> lista = new ArrayList<>();

        lista.add(new Aluno(555833, "Renan Kaique Fontes Ferreira", "Sistemas de Informação"));

        lista.add(new Aluno(132134, "Silva de teste", "Engenharia de Computação"));

        lista.add(new Aluno(758234, "Patricia Fotocópia", "Engenharia de Software"));

        lista.add(new Aluno(741231, "Bolinho Ana Maria", "Ciência da Computação"));

        lista.add(new Aluno(356123, "Bolinho Ana Maria", "Análise e Desenvolvimento de Sistemas"));


        lista.forEach(aluno -> {
            System.out.println(aluno.toString());
        });

        lista.sort(Comparator.comparing(Aluno::getNome)
                .thenComparing(Aluno::getRm));

        System.out.println();

        lista.forEach(aluno -> {
            System.out.println(aluno.toString());
        });

    }
}
