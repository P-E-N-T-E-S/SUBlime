package br.com.code.spring.sublime.obra;

import br.com.code.spring.sublime.legenda.Arquivo;

public interface FilmeInterface {
    Filme incluir(double idObra, String titulo, String duracao, String diretor, int anoLancamento,
                  String tipo, double nota, int prioridade, Arquivo[] arquivo, String caminhoLink);

    String buscar(double idObra);

    String excluir(Filme obra);

    String validar(Filme obra);

    String alterar(Filme obra);
}
