package companhia;

public class VooCharter extends Voo {
    private int quantidadePassageiros;

    public VooCharter() {
        super();
        this.quantidadePassageiros = 0;
    }

    public VooCharter(double distancia, double velocidadeMedia, String tipoVoo, int quantidadePassageiros) {
        super(distancia, velocidadeMedia, tipoVoo);
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public VooCharter(double distancia, double velocidadeMedia, int quantidadePassageiros) {
        super(distancia, velocidadeMedia);
        this.quantidadePassageiros = quantidadePassageiros;
    }

    @Override
    public double calcularTempoVoo(double fatorAeroportuario) {
        if (quantidadePassageiros < 50) {
            fatorAeroportuario = 3;
        }
        return super.calcularTempoVoo(fatorAeroportuario);
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void setQuantidadePassageiros(int quantidadePassageiros) {
        this.quantidadePassageiros = quantidadePassageiros;
    }
}
