package Legenda;

import Contribuidor.Contribuidor;

public class Legenda {
    private String texto;
    private String idioma;
    private Contribuidor contribuidor;
    private Arquivo arquivo;
    //private ObraAudioVisual obraAudioVisual;
    private int prioridade;
    private double nota;

    public Legenda(String texto, String idioma, int prioridade, double nota) {
        this.texto = texto;
        this.idioma = idioma;
        this.prioridade = prioridade;
        this.nota = nota;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }


}
