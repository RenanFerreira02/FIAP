import java.util.Scanner;


public class exemplo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double n1, n2, media;

        System.out.println("Digite as duas notas do aluno: ");
        n1 = input.nextDouble();
        n2 = input.nextDouble();

        media = (n1 + n2) / 2;

        if(media >= 6){
            System.out.println("O aluno está aprovado e a média do aluno é: " + media);

        } else {
            System.out.println("O aluno está reprovado e a média do aluno é: " + media);
            
        }


        
    }
}
