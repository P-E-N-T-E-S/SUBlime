package br.com.code.spring.sublime.tela;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TelaFeedback {
    private JFrame frame;
    private JLabel lblNota;
    private JTextArea txtComentarios;

    public TelaFeedback(double nota, List<String> comentarios) {
        initialize(nota, comentarios);
    }

    private void initialize(double nota, List<String> comentarios) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblNota = new JLabel("Nota da Legenda: " + nota);
        lblNota.setBounds(35, 30, 200, 16);
        frame.getContentPane().add(lblNota);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 60, 350, 150);
        frame.getContentPane().add(scrollPane);

        txtComentarios = new JTextArea();
        scrollPane.setViewportView(txtComentarios);

        if (comentarios != null) {
            for (String comentario : comentarios) {
                txtComentarios.append(comentario + "\n");
            }
        }

        JButton btnFechar = new JButton("Fechar");
        btnFechar.setBounds(150, 230, 100, 29);
        frame.getContentPane().add(btnFechar);
        btnFechar.addActionListener(e -> fecharTela());
    }

    private void fecharTela() {
        frame.dispose();
    }

    public void mostrarTela() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        double nota = 4.5;
        List<String> comentarios = new ArrayList<>();
        comentarios.add("Ótima legenda!");
        comentarios.add("Poderia melhorar na sincronização.");

        TelaFeedback telaFeedback = new TelaFeedback(nota, comentarios);
        telaFeedback.mostrarTela();
    }
}
