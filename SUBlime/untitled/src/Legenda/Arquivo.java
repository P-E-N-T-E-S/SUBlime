package Legenda;

import Contribuidor.Contribuidor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    private String caminhoArquivo;
    private String nomeArquivo;
    private Legenda legenda;
    private long idArquivo;
    private Contribuidor contribuidor;
    private String filmeRelacionado;
    private boolean estado;
    private File armazenaLegenda;

    public Arquivo(String caminhoArquivo, String nomeArquivo, long idArquivo, File armazenaLegenda) {
        this.caminhoArquivo = caminhoArquivo;
        this.nomeArquivo = nomeArquivo;
        this.idArquivo = idArquivo;
        this.armazenaLegenda = armazenaLegenda;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public long getIdArquivo() {
        return idArquivo;
    }

    public void setFilmeRelacionado(String filmeRelacionado) {
        this.filmeRelacionado = filmeRelacionado;
    }

    public String getFilmeRelacionado() {
        return filmeRelacionado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setContribuidor(Contribuidor contribuidor) {
        this.contribuidor = contribuidor;
    }

    public Contribuidor getContribuidor() {
        return contribuidor;
    }

    public void criaArquivo(String nomeArquivo) throws IOException {
        armazenaLegenda = new File(nomeArquivo);
        if (armazenaLegenda.createNewFile()) {
            System.out.println("Arquivo criado com sucesso! " + armazenaLegenda.getName());
        } else {
            System.out.println("Não foi possível criar o arquivo.");
        }
    }

    public void escreveArquivo(String nomeArquivo) throws IOException {
        FileWriter escreveArquivo = new FileWriter(nomeArquivo);
        escreveArquivo.write(legenda.getTexto());
        fechaArquivo(escreveArquivo);
    }

    public void fechaArquivo(FileWriter escreveArquivo) throws IOException {
        escreveArquivo.close();
    }
}
