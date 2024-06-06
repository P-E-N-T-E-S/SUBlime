package Contribuidor;

import Legenda.Arquivo;
import Legenda.Legenda;
import java.util.ArrayList;

public class Contribuidor {
    private double idUsuario;
    private String nome;
    private String email;
    private String senha;
    private ArrayList<String> idiomasDominados;
    private boolean eModerador;
    private Legenda legenda;
    private Arquivo[] arquivos;

    private ContribuidorInterface mediator;

    public Contribuidor() {
    }

    public Contribuidor(ContribuidorInterface mediator) {
        this.mediator = mediator;
    }

    public double getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(double idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getEModerador() {
        return eModerador;
    }

    public void setEModerador(boolean eModerador) {
        this.eModerador = eModerador;
    }

    public void adicionarIdiomaDominado(String idioma) {
        if (idiomasDominados == null) {
            idiomasDominados = new ArrayList<>();
        }
        idiomasDominados.add(idioma);
    }

    public void removerIdiomaDominado(String idioma) {
        if (idiomasDominados != null) {
            idiomasDominados.remove(idioma);
        }
    }

    public Contribuidor incluir(String idUsuario) {
        return mediator.incluir(idUsuario);
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
