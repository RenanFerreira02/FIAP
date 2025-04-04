package Exercicio06;

public class Hora {
    private int hora;
    private int minuto;
    private int segundo;

    public Hora(int hora, int minuto, int segundo) {
        this.hora = validarHora(hora);
        this.minuto = validarMinuto(minuto);
        this.segundo = validarSegundo(segundo);
    }

    private int validarHora(int hora) {
        return (hora >= 0 && hora <= 23) ? hora : 0;
    }

    private int validarMinuto(int minuto) {
        return (minuto >= 0 && minuto <= 59) ? minuto : 0;
    }

    private int validarSegundo(int segundo) {
        return validarMinuto(segundo);
    }

    public String formatar() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }
}
