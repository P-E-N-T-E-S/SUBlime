package br.com.code.spring.sublime.legenda;

public class ArquivoMediator implements ArquivoInterface {
    private Arquivo arquivo;

    public ArquivoMediator(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public Arquivo buscarArquivo(long idArquivo) {
        return Arquivo.buscar(idArquivo);
    }

    @Override
    public boolean validarArquivo(Arquivo arquivo) {
        return arquivo.validar();
    }

    @Override
    public boolean alterarArquivo(Arquivo arquivo) {
        return Arquivo.alterar(arquivo);
    }
}
