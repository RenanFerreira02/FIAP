import java.util.Random;

public class Bilhete {
    static final double TARIFA = 5.20;
    long numero;
    double saldo;

    Usuario usuario;

    public Bilhete(Usuario usuario) {
        numero = gerarNumero();

        this.usuario = usuario;
    }

    private long gerarNumero() {
        Random random = new Random();

        return random.nextLong(1000, 10000);
    }

    public void carregar(double valor) {
        saldo += valor;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public String passarCatraca() {
        double debito = TARIFA / 2;

        if (usuario.perfil.equalsIgnoreCase("comum")) {
            debito = TARIFA;
        }

        if (saldo >= debito) {
            saldo -= debito;
            return "Catraca Liberada";
        }

        return "Sem Saldo";
    }

}
