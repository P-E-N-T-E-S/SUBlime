package Contribuidor;

public class Moderador extends Contribuidor {
    private Contribuidor contribuidor;
    private ContribuidorInterface mediator;

    public Moderador(ContribuidorInterface mediator, double idUsuario, String nome, String email, String senha, boolean eModerador) {
        super(mediator);
        this.mediator = mediator;
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

    public Moderador incluir(String idUsuario) {
        return (Moderador) mediator.incluir(idUsuario);
    }

    public String buscar(String idUsuario) {
        return mediator.buscar(idUsuario);
    }

    public String excluir() {
        return mediator.excluir(this);
    }

    public String validar() {
        return mediator.validar(this);
    }

    public String alterar() {
        return mediator.alterar(this);
    }
}
