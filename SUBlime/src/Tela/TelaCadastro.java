package Tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro {
    private JFrame frame;
    private JTextField textFieldIdUsuario;
    private JTextField textFieldNome;
    private JTextField textFieldEmail;
    private JPasswordField passwordFieldSenha;
    private JCheckBox checkBoxEModerador;

    public TelaCadastro() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblIdUsuario = new JLabel("ID do Usuário:");
        lblIdUsuario.setBounds(35, 30, 100, 16);
        frame.getContentPane().add(lblIdUsuario);

        textFieldIdUsuario = new JTextField();
        textFieldIdUsuario.setBounds(150, 30, 200, 26);
        frame.getContentPane().add(textFieldIdUsuario);
        textFieldIdUsuario.setColumns(10);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(35, 70, 100, 16);
        frame.getContentPane().add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(150, 70, 200, 26);
        frame.getContentPane().add(textFieldNome);
        textFieldNome.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(35, 110, 100, 16);
        frame.getContentPane().add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(150, 110, 200, 26);
        frame.getContentPane().add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(35, 150, 100, 16);
        frame.getContentPane().add(lblSenha);

        passwordFieldSenha = new JPasswordField();
        passwordFieldSenha.setBounds(150, 150, 200, 26);
        frame.getContentPane().add(passwordFieldSenha);

        checkBoxEModerador = new JCheckBox("É Moderador");
        checkBoxEModerador.setBounds(150, 190, 128, 23);
        frame.getContentPane().add(checkBoxEModerador);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 230, 100, 29);
        frame.getContentPane().add(btnSalvar);
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarContribuidor();
            }
        });
    }

    private void salvarContribuidor() {
        String idUsuario = textFieldIdUsuario.getText();
        String nome = textFieldNome.getText();
        String email = textFieldEmail.getText();
        String senha = new String(passwordFieldSenha.getPassword());
        boolean eModerador = checkBoxEModerador.isSelected();

        JOptionPane.showMessageDialog(frame, "Contribuidor salvo com sucesso!");
    }

    public void mostrarTela() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.mostrarTela();
    }
}
