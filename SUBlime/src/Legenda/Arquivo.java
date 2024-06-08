package Legenda;

import Contribuidor.Contribuidor;
import utils.StringUtils;

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

    public void criaArquivo(String caminhoArquivo, String nomeArquivo) throws IOException {
        File diretorio = new File(caminhoArquivo);
        if (!diretorio.exists()) {
            diretorio.mkdirs(); // Cria o diretório se não existir
        }

        armazenaLegenda = new File(diretorio, nomeArquivo);
        if (!armazenaLegenda.exists()) {
            if (armazenaLegenda.createNewFile()) {
                System.out.println("Arquivo criado com sucesso! " + armazenaLegenda.getName());
            } else {
                System.out.println("Não foi possível criar o arquivo.");
            }
        } else {
            System.out.println("Arquivo já existe e será sobrescrito.");
        }
    }

    public void escreveArquivo(String caminhoArquivo, String nomeArquivo) throws IOException {
        try (FileWriter escreveArquivo = new FileWriter(new File(caminhoArquivo, nomeArquivo), false)) { // Sobrescreve o arquivo
            escreveArquivo.write(legenda.getTexto());
        } catch (IOException e) {
            throw new IOException("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public void criaEEscreveArquivo(String caminhoArquivo, String nomeArquivo, Legenda legenda) throws IOException {
        if (!StringUtils.isVazioOuNulo(caminhoArquivo) && !StringUtils.isVazioOuNulo(nomeArquivo) && legenda != null) {
            setCaminhoArquivo(caminhoArquivo);
            setNomeArquivo(nomeArquivo);
            setLegenda(legenda);
            criaArquivo(caminhoArquivo, nomeArquivo);
            escreveArquivo(caminhoArquivo, nomeArquivo);
        } else {
            throw new IllegalArgumentException("Caminho, nome do arquivo ou legenda estão vazios ou nulos.");
        }
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
