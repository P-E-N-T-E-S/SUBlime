package Obra;

import Legenda.Arquivo;

public class Filme {
    private double idObra;
    private String titulo;
    private String duracao;
    private String diretor;
    private int anoLancamento;
    private String tipo;
    private double nota;
    private int prioridade;
    private Arquivo[] arquivo;
    private String caminhoLink;

    public Filme(double idObra, String titulo, String duracao, String diretor, int anoLancamento,
                 String tipo, double nota, int prioridade, Arquivo[] arquivo, String caminhoLink) {
        this.idObra = idObra;
        this.titulo = titulo;
        this.duracao = duracao;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.tipo = tipo;
        this.nota = nota;
        this.prioridade = prioridade;
        this.arquivo = arquivo;
        this.caminhoLink = caminhoLink;
    }

    public double getIdObra() {
        return idObra;
    }

    public String getCaminhoLink() {
        return caminhoLink;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Arquivo[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo[] arquivo) {
        this.arquivo = arquivo;
    }

    public void setCaminhoLink(String caminhoLink) {
        this.caminhoLink = caminhoLink;
    }

    @Override
    public String toString() {
        return "ObraAudioVisual{" +
                "idObra=" + idObra +
                ", titulo='" + titulo + '\'' +
                ", duracao='" + duracao + '\'' +
                ", diretor='" + diretor + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", tipo='" + tipo + '\'' +
                ", nota=" + nota +
                ", prioridade=" + prioridade +
                ", caminhoLink='" + caminhoLink + '\'' +
                '}';
    }
}