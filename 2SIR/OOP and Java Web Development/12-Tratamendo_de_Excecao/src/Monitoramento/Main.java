package Monitoramento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Sensor> listaSensor = new ArrayList<>();

        List<List<Double>> listaTemperatura = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            listaSensor.add(new Sensor(String.valueOf(i)));

            listaTemperatura.add(gerar(i));
        }

        SistemaMonitoramento sistemaMonitoramento = new SistemaMonitoramento();

        sistemaMonitoramento.processarSensores(listaSensor, listaTemperatura);

        sistemaMonitoramento.exibirRelatorio();
    }

    private static List<Double> gerar(int i) {
        Random random = new Random();

        List<Double> lista = new ArrayList<>();

        int total = 100;

        double limite = 60;

        switch (i) {
            case 2 -> total = total / 2;

            case 3 -> limite = limite * 2;
        }

        for (int k = 0; k < total; k++) {
            lista.add(random.nextDouble(-limite, limite));
        }

        return lista;
    }
}
