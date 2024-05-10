package Contribuidor;

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

    public String getIdUsuario() {
        return Double.toString(idUsuario);
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
}