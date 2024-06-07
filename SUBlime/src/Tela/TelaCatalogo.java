package Tela;

import Obra.ObraAudioVisual;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TelaCatalogo {
    private List<ObraAudioVisual> obras;

    public TelaCatalogo() {
        this.obras = new ArrayList<>();
    }

    public void adicionarObra(ObraAudioVisual obra) {
        this.obras.add(obra);
    }

    public void removerObra(double idObra) {
        this.obras.removeIf(obra -> obra.getIdObra() == idObra);
    }

    public List<ObraAudioVisual> listarObras() {
        return new ArrayList<>(this.obras);
    }

    public ObraAudioVisual buscarObraPorId(double idObra) {
        for (ObraAudioVisual obra : obras) {
            if (obra.getIdObra() == idObra) {
                return obra;
            }
        }
        return null;
    }

    public List<ObraAudioVisual> buscarObrasPorTitulo(String titulo) {
        return this.obras.stream()
                .filter(obra -> obra.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        TelaCatalogo catalogo = new TelaCatalogo();

        ObraAudioVisual obra1 = new ObraAudioVisual(1, "Howl's Moving Castle", "130min", "Hayao Miyazaki", 2004, "Filme", 8.2, 1, null, "/link/to/howls");
        ObraAudioVisual obra2 = new ObraAudioVisual(2, "Spirited Away", "125min", "Hayao Miyazaki", 2001, "Filme", 8.6, 1, null, "/link/to/spirited");

        catalogo.adicionarObra(obra1);
        catalogo.adicionarObra(obra2);

        List<ObraAudioVisual> todasObras = catalogo.listarObras();
        System.out.println("Todas as obras: " + todasObras);

        ObraAudioVisual obraBuscada = catalogo.buscarObraPorId(1);
        System.out.println("Obra buscada por ID: " + obraBuscada);

        List<ObraAudioVisual> obrasBuscadasPorTitulo = catalogo.buscarObrasPorTitulo("Spirited Away");
        System.out.println("Obras buscadas por título: " + obrasBuscadasPorTitulo);
    }
}