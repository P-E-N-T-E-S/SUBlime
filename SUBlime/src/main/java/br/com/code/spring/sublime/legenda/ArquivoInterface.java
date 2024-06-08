package br.com.code.spring.sublime.legenda;

public interface ArquivoInterface {
    Arquivo buscarArquivo(long idArquivo);
    boolean validarArquivo(Arquivo arquivo);
    boolean alterarArquivo(Arquivo arquivo);
}
