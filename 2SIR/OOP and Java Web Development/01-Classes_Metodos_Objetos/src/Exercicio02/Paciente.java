package Exercicio02;

public class Paciente {
    String nome;
    int idade;

    public int frequenciaCardiacaMaxima() {
     return 220 - idade;
    }

    public double[] frequenciaCardiacaAlvo() {
        double[] frequenciaAlvo = new double[2];
        int frequenciaMaxima = frequenciaCardiacaMaxima();

        frequenciaAlvo[0] = frequenciaMaxima * 0.5;
        frequenciaAlvo[1] = frequenciaMaxima * 0.85;

        return frequenciaAlvo;
    }
}
