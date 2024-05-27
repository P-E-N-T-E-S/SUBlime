package Legenda;

public class ArquivoMediatorImpl implements ArquivoMediator {
    private Arquivo arquivo;

    public ArquivoMediatorImpl(Arquivo arquivo) {
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
        return arquivo.alterar(arquivo);
    }
}
