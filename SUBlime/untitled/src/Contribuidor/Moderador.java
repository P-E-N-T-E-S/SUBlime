package Contribuidor;

public class Moderador extends Contribuidor {
    private Contribuidor contribuidor;

    public Moderador(double idUsuario, String nome, String email, String senha, boolean eModerador) {
        super();
        this.setIdUsuario(idUsuario);
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.setEModerador(eModerador);
    }

    public Contribuidor getContribuidor() {
        return contribuidor;
    }

    public void setContribuidor(Contribuidor contribuidor) {
        this.contribuidor = contribuidor;
    }
}