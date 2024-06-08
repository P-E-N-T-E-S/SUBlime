package br.com.code.spring.sublime.obra;

import br.com.code.spring.sublime.legenda.Arquivo;
import java.util.HashMap;
import java.util.Map;

public class FilmeMediator implements FilmeInterface {
    private Map<Double, Filme> obras = new HashMap<>();

    @Override
    public Filme incluir(double idObra, String titulo, String duracao, String diretor, int anoLancamento,
                         String tipo, double nota, int prioridade, Arquivo[] arquivo, String caminhoLink) {
        if (obras.containsKey(idObra)) {
            return obras.get(idObra);
        } else {
            Filme novaObra = new Filme(idObra, titulo, duracao, diretor, anoLancamento,
                    tipo, nota, prioridade, null, caminhoLink);
            obras.put(idObra, novaObra);
            return novaObra;
        }
    }

    @Override
    public String buscar(double idObra) {
        Filme obra = obras.get(idObra);
        return obra != null ? obra.toString() : "Obra não encontrada.";
    }

    @Override
    public String excluir(Filme obra) {
        if (obras.containsValue(obra)) {
            obras.remove(obra.getIdObra());
            return "Obra excluída com sucesso.";
        } else {
            return "Obra não encontrada.";
        }
    }

    @Override
    public String validar(Filme obra) {
        if (obra.getTitulo() != null && obra.getDiretor() != null && obra.getTipo() != null &&
                obra.getDuracao() != null && obra.getCaminhoLink() != null && obra.getArquivo() != null &&
                obra.getIdObra() > 0 && obra.getAnoLancamento() > 0 && obra.getNota() >= 0 &&
                obra.getPrioridade() >= 0) {
            return "Obra válida.";
        } else {
            return "Obra inválida.";
        }
    }

    @Override
    public String alterar(Filme obra) {
        double idObra = obra.getIdObra();
        if (obras.containsKey(idObra)) {
            obras.put(idObra, obra);
            return "Obra alterada com sucesso.";
        } else {
            return "Obra não encontrada.";
        }
    }
}
