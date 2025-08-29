import java.util.HashSet;
import java.util.Set;

public class Set_Collection {
    public static void main(String[] args) {
        Set<Aluno> lista = new HashSet<>();

        lista.add(new Aluno(555833, "Renan Kaique Fontes Ferreira", "Sistemas de Informação"));

        lista.add(new Aluno(132134, "Silva de teste", "Engenharia de Computação"));

        lista.add(new Aluno(758234, "Patricia Fotocópia", "Engenharia de Software"));

        lista.add(new Aluno(132134, "Bolinho Ana Maria", "Ciência da Computação"));

        lista.forEach(aluno -> {
            System.out.println(aluno.toString());
        });


    }
}
