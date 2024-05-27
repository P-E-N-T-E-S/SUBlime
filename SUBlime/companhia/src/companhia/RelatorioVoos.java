package companhia;

import java.util.ArrayList;
import java.util.List;

public class RelatorioVoos {
    private List<Voo> voos;

    public RelatorioVoos() {
        this.voos = new ArrayList<>();
    }

    public void adicionarVoo(Voo voo) {
        voos.add(voo);
    }

    public void imprimirRelatorio(double fatorAeroportuario) {
        System.out.println("Relatório de Voos:\n");
        for (Voo voo : voos) {
            System.out.println("Distância: " + voo.getDistancia() + " km");
            System.out.println("Velocidade Média: " + voo.getVelocidadeMedia() + " km/h");
            double tempoVoo = voo.calcularTempoVoo(fatorAeroportuario, 0); // Considerando velocidade de arrasto do vento zero
            System.out.println("Tempo de Voo: " + tempoVoo + " horas");
            if (voo instanceof VooCharter) {
                VooCharter vooCharter = (VooCharter) voo;
                System.out.println("Quantidade de Passageiros: " + vooCharter.getQuantidadePassageiros());
            }
            System.out.println();
        }
    }
}
