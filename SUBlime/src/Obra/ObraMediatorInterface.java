package Obra;

import Legenda.Arquivo;

public interface ObraMediatorInterface {
    ObraAudioVisual incluir(double idObra, String titulo, String duracao, String diretor, int anoLancamento,
                            String tipo, double nota, int prioridade, Arquivo[] arquivo, String caminhoLink);

    String buscar(double idObra);

    String excluir(ObraAudioVisual obra);

    String validar(ObraAudioVisual obra);

    String alterar(ObraAudioVisual obra);
}
