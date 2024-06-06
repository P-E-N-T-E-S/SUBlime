package Legenda;

import Contribuidor.Contribuidor;

public class Legenda {
    private long id;
    private String texto;
    private String idioma;
    private Contribuidor contribuidor;
    private Arquivo arquivo;
    private int prioridade;
    private double nota;

    public Legenda(String texto, String idioma, int prioridade, double nota) {
        this.texto = texto;
        this.idioma = idioma;
        this.prioridade = prioridade;
        this.nota = nota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Contribuidor getContribuidor() {
        return contribuidor;
    }

    public void setContribuidor(Contribuidor contribuidor) {
        this.contribuidor = contribuidor;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}