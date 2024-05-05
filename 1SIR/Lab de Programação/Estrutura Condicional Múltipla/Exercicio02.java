public class Exercicio02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String letra;

        System.out.println("Digite uma letra: ");
        letra = input.next();

        letra = letra.toLowerCase();

        switch (letra) {

            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                System.out.println("É vogal");
                break;

            default:
                System.out.println("Não é vogal");
        }
    }

}
