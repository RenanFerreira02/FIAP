package Exercicio01;

public class Aluno {

    //Variáveis Globais
    //Atributos ou campos ou Variáveis de Instância(objeto)

    int rm;
    String nome;
    double n1;
    double n2;

    // Método para calcular e retornar a média
    public double calcularMedia() {

        return (n1 + n2) / 2;
    }

    //Método para retornar o status(aprovado ou reprovado) do aluno
    public String verificaStatus(){
        if(calcularMedia() >= 6) {
            return "APROVADO";
        }
        return "REPROVADO";
    }
}

