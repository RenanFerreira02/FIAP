public class Professor {

    private String nome;
    private String titulo;
    private int totalDeAulas;
    private double horasDeAulas;


    public Professor(String nome, String titulo, int totalDeAulas, double horasDeAulas) {
        this.nome = nome;
        this.titulo = titulo;
        this.totalDeAulas = totalDeAulas;
        this.horasDeAulas = horasDeAulas;
    }

    // cálculo do salário do professor
    public double salarioBase() {
        double horaAtividade, descansoRenumerado;

        double salario = totalDeAulas * 4.5 * horasDeAulas;

        if (titulo.equalsIgnoreCase("mestre")) {
            salario += salario * 0.085;
        } else if (titulo.equalsIgnoreCase("doutor")) {
            salario += salario * 0.12;
        }

        horaAtividade = (salario * 5) / 100;

        descansoRenumerado = (salario + horaAtividade) / 6;

        return (salario + horaAtividade + descansoRenumerado);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


}
