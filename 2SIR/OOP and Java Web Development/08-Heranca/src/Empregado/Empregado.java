package Empregado;

public abstract class Empregado {
    long matricula;
    private String nome;

    public Empregado(long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        String aux = "";

        aux += "Matricula: " + matricula + "\n";
        aux += "Nome: " + nome + "\n";

        return aux;
    }
}
