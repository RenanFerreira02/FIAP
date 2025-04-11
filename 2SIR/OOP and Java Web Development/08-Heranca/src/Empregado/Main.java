package Empregado;

public class Main {
    public static void main(String[] args) {
        Empregado[] empregados = new Empregado[3];

        empregados[0] = new EmpregadoComissionado();
        empregados[1] = new EmpregadoHorista();
        empregados[2] = new EmpregadoHorista();

        for (Empregado empregado : empregados) {
            System.out.println(empregado.nome);
            System.out.println(empregado.calcularSalario());
        }
    }
}
