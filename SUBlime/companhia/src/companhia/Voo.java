package companhia;

public class Voo {
    private double distancia;
    private double velocidadeMedia;
    private String tipoVoo;

    public Voo() {
        this.distancia = 0;
        this.velocidadeMedia = 0;
        this.tipoVoo = "comercial";
    }

    public Voo(double distancia, double velocidadeMedia, String tipoVoo) {
        this.distancia = distancia;
        this.velocidadeMedia = velocidadeMedia;
        this.tipoVoo = tipoVoo;
    }

    public Voo(double distancia, double velocidadeMedia) {
        this.distancia = distancia;
        this.velocidadeMedia = velocidadeMedia;
        this.tipoVoo = "comercial";
    }

    public double calcularTempoVoo(double fatorAeroportuario) {
        return (distancia / velocidadeMedia) * (1 + fatorAeroportuario / 100);
    }

    public double calcularTempoVoo(double fatorAeroportuario, double velocidadeArrastoVento) {
        return (distancia / (velocidadeMedia + velocidadeArrastoVento)) * (1 + fatorAeroportuario / 100);
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public String getTipoVoo() {
        return tipoVoo;
    }

    public void setTipoVoo(String tipoVoo) {
        this.tipoVoo = tipoVoo;
    }
}