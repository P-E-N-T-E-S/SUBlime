package Tela;

import Legenda.Legenda;
import utils.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaLegenda {
    private JFrame frame;
    private JTextArea textAreaLegenda;

    public TelaLegenda() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblEscreverLegenda = new JLabel("Escrever Legenda:");
        lblEscreverLegenda.setBounds(35, 30, 200, 16);
        frame.getContentPane().add(lblEscreverLegenda);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 60, 350, 150);
        frame.getContentPane().add(scrollPane);

        textAreaLegenda = new JTextArea();
        scrollPane.setViewportView(textAreaLegenda);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 230, 100, 29);
        frame.getContentPane().add(btnSalvar);
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarLegenda();
            }
        });
    }

    private void salvarLegenda() {
        String legendaTexto = textAreaLegenda.getText();

        if (!StringUtils.isVazioOuNulo(legendaTexto)) {
            Legenda legenda = new Legenda(1, legendaTexto, "Português", 1, 5.0); // Exemplo de inicialização

            try {
                legenda.salvarLegenda("textos/", "legenda.txt");
                JOptionPane.showMessageDialog(frame, "Legenda salva com sucesso!");
                limparCampos();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Erro ao salvar a legenda: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(frame, "O texto da legenda está vazio!");
        }
    }

    private void limparCampos() {
        textAreaLegenda.setText("");
    }

    public void mostrarTela() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TelaLegenda telaLegenda = new TelaLegenda();
        telaLegenda.mostrarTela();
    }
}
