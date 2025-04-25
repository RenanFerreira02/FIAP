package Empregado;

public class Main {
    public static void main(String[] args) {
        Empregado[] empregados = new Empregado[3];

        empregados[0] = new EmpregadoComissionado(1,"Renan", 2000000, 30);
        empregados[1] = new EmpregadoHorista(2, "David", 210, 175.00);
        empregados[2] = new EmpregadoHorista(3, "Enzo", 10, 35.00);

        for (Empregado empregado : empregados) {
            System.out.println(empregado);
            System.out.println("Salário: R$ "+ empregado.calcularSalario() + "\n");
        }
    }
}
