package companhia;

public class VooComercial extends Voo {

    public VooComercial() {
        super();
    }

    public VooComercial(double distancia, double velocidadeMedia, String tipoVoo) {
        super(distancia, velocidadeMedia, tipoVoo);
    }

    public VooComercial(double distancia, double velocidadeMedia) {
        super(distancia, velocidadeMedia);
    }

    @Override
    public double calcularTempoVoo(double fatorAeroportuario) {
        return super.calcularTempoVoo(fatorAeroportuario);
    }
}
