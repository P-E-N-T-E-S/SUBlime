package Legenda;

import Contribuidor.Contribuidor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
    private String caminhoArquivo;
    private String nomeArquivo;
    private Legenda legenda;
    private long idArquivo;
    private Contribuidor contribuidor;
    private String filmeRelacionado;
    private boolean estado;
    private File armazenaLegenda;
    private static ArrayList<Arquivo> arquivos = new ArrayList<>();
    private ArquivoMediator mediator;

    public Arquivo(String caminhoArquivo, String nomeArquivo, long idArquivo, File armazenaLegenda) {
        this.caminhoArquivo = caminhoArquivo;
        this.nomeArquivo = nomeArquivo;
        this.idArquivo = idArquivo;
        this.armazenaLegenda = armazenaLegenda;
    }

    public long getIdArquivo() {
        return idArquivo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public Legenda getLegenda() {
        return legenda;
    }

    public void setLegenda(Legenda legenda) {
        this.legenda = legenda;
    }

    public Contribuidor getContribuidor() {
        return contribuidor;
    }

    public void setContribuidor(Contribuidor contribuidor) {
        this.contribuidor = contribuidor;
    }

    public String getFilmeRelacionado() {
        return filmeRelacionado;
    }

    public void setFilmeRelacionado(String filmeRelacionado) {
        this.filmeRelacionado = filmeRelacionado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public File getArmazenaLegenda() {
        return armazenaLegenda;
    }

    public void setArmazenaLegenda(File armazenaLegenda) {
        this.armazenaLegenda = armazenaLegenda;
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

    public static Arquivo buscar(long idArquivo) {
        for (Arquivo arquivo : arquivos) {
            if (arquivo.getIdArquivo() == idArquivo) {
                return arquivo;
            }
        }
        return null;
    }

    public boolean validar() {
        return caminhoArquivo != null && !caminhoArquivo.isEmpty() &&
                nomeArquivo != null && !nomeArquivo.isEmpty() &&
                idArquivo > 0 && armazenaLegenda != null;
    }

    public static boolean alterar(Arquivo arquivoAlterado) {
        for (int i = 0; i < arquivos.size(); i++) {
            if (arquivos.get(i).getIdArquivo() == arquivoAlterado.getIdArquivo()) {
                arquivos.set(i, arquivoAlterado);
                return true;
            }
        }
        return false;
    }

    public static void adicionarArquivo(Arquivo arquivo) {
        arquivos.add(arquivo);
    }
}
