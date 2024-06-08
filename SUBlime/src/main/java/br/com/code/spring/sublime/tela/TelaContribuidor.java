package br.com.code.spring.sublime.tela;

import br.com.code.spring.sublime.contribuidor.Contribuidor;

import javax.swing.*;

public class TelaContribuidor {
    private JFrame frame;
    private JLabel lblIdUsuario;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblSenha;
    private JLabel lblIdiomas;
    private JLabel lblModerador;

    private JTextField txtIdUsuario;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JTextArea txtIdiomas;
    private JCheckBox chkModerador;

    public TelaContribuidor() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblIdUsuario = new JLabel("ID do Usuário:");
        lblIdUsuario.setBounds(35, 30, 100, 16);
        frame.getContentPane().add(lblIdUsuario);

        txtIdUsuario = new JTextField();
        txtIdUsuario.setBounds(150, 30, 200, 20);
        frame.getContentPane().add(txtIdUsuario);
        txtIdUsuario.setEditable(false);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(35, 60, 100, 16);
        frame.getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(150, 60, 200, 20);
        frame.getContentPane().add(txtNome);

        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(35, 90, 100, 16);
        frame.getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 90, 200, 20);
        frame.getContentPane().add(txtEmail);

        lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(35, 120, 100, 16);
        frame.getContentPane().add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(150, 120, 200, 20);
        frame.getContentPane().add(txtSenha);

        lblIdiomas = new JLabel("Idiomas:");
        lblIdiomas.setBounds(35, 150, 100, 16);
        frame.getContentPane().add(lblIdiomas);

        txtIdiomas = new JTextArea();
        txtIdiomas.setBounds(150, 150, 200, 60);
        txtIdiomas.setLineWrap(true);
        frame.getContentPane().add(txtIdiomas);

        lblModerador = new JLabel("Moderador:");
        lblModerador.setBounds(35, 220, 100, 16);
        frame.getContentPane().add(lblModerador);

        chkModerador = new JCheckBox();
        chkModerador.setBounds(150, 220, 20, 20);
        frame.getContentPane().add(chkModerador);
    }

    public void mostrarTela() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TelaContribuidor telaContribuidor = new TelaContribuidor();
        telaContribuidor.mostrarTela();
    }
}
