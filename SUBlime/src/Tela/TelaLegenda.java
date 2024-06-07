package Tela;

import Legenda.Legenda;
import Legenda.LegendaDAO;
import Legenda.LegendaMediator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLegenda {
    private JFrame frame;
    private JTextArea textAreaLegenda;
    private LegendaMediator legendaMediator;

    public TelaLegenda() {
        LegendaDAO legendaDAO = new LegendaDAO();
        legendaMediator = new LegendaMediator(legendaDAO);
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
        Legenda legenda = new Legenda(0, legendaTexto, "Português", 0, 0);

        String mensagem = legendaMediator.save(legenda);
        JOptionPane.showMessageDialog(frame, mensagem);

        if (mensagem.equals("Legenda salva com sucesso!")) {
            limparCampos();
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