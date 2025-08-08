package Monitoramento;

public class LeituraInvalidaException extends Exception {
    public LeituraInvalidaException(int posicao, double temperatura) {
      super("Leitura inválida na posição " + posicao + ": " + temperatura + "ºC👿");
    }

}
