package Legenda;

import Contribuidor.Contribuidor;
import utils.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Legenda {
    private long id;
    private String texto;
    private String idioma;
    private Contribuidor contribuidor;
    private Arquivo arquivo;
    private int prioridade;
    private double nota;

    public Legenda(long id, String texto, String idioma, int prioridade, double nota) {
        this.id = id;
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

    public void salvarLegenda(String caminhoArquivo, String nomeArquivo) throws IOException {
        if (!StringUtils.isVazioOuNulo(caminhoArquivo) && !StringUtils.isVazioOuNulo(nomeArquivo) && !StringUtils.isVazioOuNulo(texto)) {
            File diretorio = new File(caminhoArquivo);
            if (!diretorio.exists()) {
                diretorio.mkdirs(); // Cria o diretório se não existir
            }

            File arquivo = new File(diretorio, nomeArquivo);
            if (!arquivo.exists()) {
                if (arquivo.createNewFile()) {
                    System.out.println("Arquivo criado com sucesso! " + arquivo.getName());
                } else {
                    System.out.println("Não foi possível criar o arquivo.");
                }
            } else {
                System.out.println("Arquivo já existe e será sobrescrito.");
            }

            try (FileWriter escreveArquivo = new FileWriter(arquivo, false)) {
                escreveArquivo.write(this.texto);
            } catch (IOException e) {
                throw new IOException("Erro ao escrever no arquivo: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Caminho, nome do arquivo ou texto da legenda estão vazios ou nulos.");
        }
    }
}
