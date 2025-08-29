import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map_Collection {
    public static void main(String[] args) {
        Aluno aluno;

        Map<Integer, Aluno> lista = new HashMap<>();

        lista.put(555833, new Aluno(555833, "Renan Kaique Fontes Ferreira", "Sistemas de Informação"));

        lista.put(132134, new Aluno(132134, "Silva de teste", "Engenharia de Computação"));

        lista.put(758234, new Aluno(758234, "Patricia Fotocópia", "Engenharia de Software"));

        lista.put(132134, new Aluno(132134, "Bolinho Ana Maria", "Ciência da Computação"));

        System.out.println(lista.get(132134));

        Set<Integer> chave = lista.keySet();

        chave.forEach(c -> System.out.println(lista.get(c)));
    }
}
