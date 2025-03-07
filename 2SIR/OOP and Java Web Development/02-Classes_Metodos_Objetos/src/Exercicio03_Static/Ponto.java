package Exercicio03_Static;

public class Ponto {
    // Variáveis de instância ou Atributos
    double x;
    double y;


    // Método para calcular e retornar a distância entre dois pontos
    public double calcularDistancia(Ponto p) {
        double distancia = Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));

        return distancia;
    }

    // Método para calcular e retornar a distância de um ponto até a origem
    public double calcularDistanciaAteOrigem() {
        Ponto origem = new Ponto();

        return calcularDistancia(origem);
    }

    // Método para calcular e retornar o ponto mais proximo da origem
    public static Ponto maisProximoDaOrigem(Ponto p1, Ponto p2) {
        double dp1 = p1.calcularDistanciaAteOrigem();
        double dp2 = p2.calcularDistanciaAteOrigem();

        if (dp1 < dp2) {
            return p1;
        }
        return p2;
    }

    // Método para retornar os dados do objeto formatado
    public String formatarPonto() {
        return "(" + x + "," + y + ")";
    }


}
