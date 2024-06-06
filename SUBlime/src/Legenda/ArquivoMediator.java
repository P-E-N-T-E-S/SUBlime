package Legenda;

public interface ArquivoMediator {
    Arquivo buscarArquivo(long idArquivo);
    boolean validarArquivo(Arquivo arquivo);
    boolean alterarArquivo(Arquivo arquivo);
}
