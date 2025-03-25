public class Main {
    public static void main(String[] args) {

        Professor professor = new Professor("Nivaldo", "doutor", 40, 180);

        System.out.println(professor.salarioBase());

        professor.setNome("Patricia");

        System.out.println(professor.getNome());

    }
}