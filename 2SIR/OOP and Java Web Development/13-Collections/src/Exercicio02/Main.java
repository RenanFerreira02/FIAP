package Exercicio02;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Alunos matrículados em Banco de Dados
        Set<Aluno> turmaBD = new HashSet<>();

        turmaBD.add(new Aluno(10, "A", "A"));
        turmaBD.add(new Aluno(20, "B", "B"));
        turmaBD.add(new Aluno(10, "C", "C"));
        turmaBD.add(new Aluno(30, "D", "D"));

        // Alunos matrículados em Estrutura de Dados
        Set<Aluno> turmaED = new HashSet<>();

        turmaED.add(new Aluno(20, "B", "B"));
        turmaED.add(new Aluno(30, "D", "D"));
        turmaED.add(new Aluno(40, "E", "E"));

        // Lista alunos turmaBD
//        turmaBD.forEach(aluno -> System.out.println(aluno));

        // Lista alunos turmaED
//        turmaED.forEach(aluno -> System.out.println(aluno));

        // Lista todos os alunos matrículados
        Set<Aluno> uniao = new  HashSet<>(turmaBD);

        uniao.addAll(turmaED);

        uniao.retainAll(turmaBD);

        uniao.forEach(aluno -> System.out.println(aluno));

    }
}
