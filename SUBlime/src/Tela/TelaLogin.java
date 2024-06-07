package Tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin {
    private JFrame frame;
    private JTextField textFieldEmail;
    private JPasswordField passwordFieldSenha;

    public TelaLogin() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(35, 70, 100, 16);
        frame.getContentPane().add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(150, 70, 200, 26);
        frame.getContentPane().add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(35, 110, 100, 16);
        frame.getContentPane().add(lblSenha);

        passwordFieldSenha = new JPasswordField();
        passwordFieldSenha.setBounds(150, 110, 200, 26);
        frame.getContentPane().add(passwordFieldSenha);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 150, 100, 29);
        frame.getContentPane().add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
    }

    private void realizarLogin() {
        String email = textFieldEmail.getText();
        String senha = new String(passwordFieldSenha.getPassword());

        boolean loginValido = "pentes@gmail.com".equals(email) && "pentes".equals(senha);

        if (loginValido) {
            JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(frame, "Email ou senha incorretos. Tente novamente.");
        }
    }

    public void mostrarTela() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.mostrarTela();
    }
}
