package Tela;

import Obra.ObraAudioVisual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TelaCatalogo {
    private List<ObraAudioVisual> obras;
    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> listObras;
    private JTextField searchField;

    public TelaCatalogo() {
        this.obras = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Catálogo de Obras Audiovisuais");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        listObras = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listObras);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new BorderLayout());
        frame.getContentPane().add(panelTop, BorderLayout.NORTH);

        JLabel lblSearch = new JLabel("Buscar por Título:");
        panelTop.add(lblSearch, BorderLayout.WEST);

        searchField = new JTextField();
        panelTop.add(searchField, BorderLayout.CENTER);
        searchField.setColumns(10);

        JButton btnSearch = new JButton("Buscar");
        panelTop.add(btnSearch, BorderLayout.EAST);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarObrasPorTitulo();
            }
        });

        JButton btnAdicionar = new JButton("Adicionar Obra");
        frame.getContentPane().add(btnAdicionar, BorderLayout.SOUTH);
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarObraDemo();
            }
        });
    }

    private void adicionarObraDemo() {
        ObraAudioVisual obra1 = new ObraAudioVisual(1, "Howl's Moving Castle", "130min", "Hayao Miyazaki", 2004, "Filme", 8.2, 1, null, "/link/to/howls");
        ObraAudioVisual obra2 = new ObraAudioVisual(2, "Spirited Away", "125min", "Hayao Miyazaki", 2001, "Filme", 8.6, 1, null, "/link/to/spirited");

        adicionarObra(obra1);
        adicionarObra(obra2);
        listarObras();
    }

    public void adicionarObra(ObraAudioVisual obra) {
        this.obras.add(obra);
        listarObras();
    }

    public void removerObra(double idObra) {
        this.obras.removeIf(obra -> obra.getIdObra() == idObra);
        listarObras();
    }

    public void listarObras() {
        listModel.clear();
        for (ObraAudioVisual obra : obras) {
            listModel.addElement(obra.getTitulo());
        }
    }

    public ObraAudioVisual buscarObraPorId(double idObra) {
        for (ObraAudioVisual obra : obras) {
            if (obra.getIdObra() == idObra) {
                return obra;
            }
        }
        return null;
    }

    public void buscarObrasPorTitulo() {
        String titulo = searchField.getText();
        List<ObraAudioVisual> obrasFiltradas = this.obras.stream()
                .filter(obra -> obra.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toList());

        listModel.clear();
        for (ObraAudioVisual obra : obrasFiltradas) {
            listModel.addElement(obra.getTitulo());
        }
    }

    public void mostrarTela() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TelaCatalogo telaCatalogo = new TelaCatalogo();
        telaCatalogo.mostrarTela();
    }
}
