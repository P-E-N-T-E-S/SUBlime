package companhia;

public class VooPrivado extends Voo {
    private double velocidadeMinima;

    public VooPrivado() {
        super();
        this.velocidadeMinima = 0;
    }

    public VooPrivado(double distancia, double velocidadeMedia, String tipoVoo, double velocidadeMinima) {
        super(distancia, velocidadeMedia, tipoVoo);
        this.velocidadeMinima = velocidadeMinima;
    }

    public VooPrivado(double distancia, double velocidadeMedia, double velocidadeMinima) {
        super(distancia, velocidadeMedia);
        this.velocidadeMinima = velocidadeMinima;
    }

    @Override
    public double calcularTempoVoo(double fatorAeroportuario) {
        return getDistancia() / (velocidadeMinima / (1 + fatorAeroportuario / 100));
    }

    public double getVelocidadeMinima() {
        return velocidadeMinima;
    }

    public void setVelocidadeMinima(double velocidadeMinima) {
        this.velocidadeMinima = velocidadeMinima;
    }
}