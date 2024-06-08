package br.com.code.spring.sublime.legenda;

import java.sql.*;
import java.io.File;
import br.com.code.spring.sublime.contribuidor.Contribuidor;

public class ArquivoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    public void save(Arquivo arquivo) {
        String sql = "INSERT INTO Arquivo (caminhoArquivo, nomeArquivo, idArquivo, filmeRelacionado, estado, idContribuidor) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, arquivo.getCaminhoArquivo());
            stmt.setString(2, arquivo.getNomeArquivo());
            stmt.setLong(3, arquivo.getIdArquivo());
            stmt.setString(4, arquivo.getFilmeRelacionado());
            stmt.setBoolean(5, arquivo.isEstado());
            stmt.setDouble(6, arquivo.getContribuidor().getIdUsuario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Arquivo findById(long idArquivo) {
        String sql = "SELECT * FROM Arquivo WHERE idArquivo = ?";
        Arquivo arquivo = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, idArquivo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Contribuidor contribuidor = new Contribuidor();
                contribuidor.setIdUsuario(rs.getDouble("idContribuidor"));

                arquivo = new Arquivo(
                        rs.getString("caminhoArquivo"),
                        rs.getString("nomeArquivo"),
                        rs.getLong("idArquivo"),
                        new File(rs.getString("caminhoArquivo"))
                );
                arquivo.setFilmeRelacionado(rs.getString("filmeRelacionado"));
                arquivo.setEstado(rs.getBoolean("estado"));
                arquivo.setContribuidor(contribuidor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arquivo;
    }

    public void update(Arquivo arquivo) {
        String sql = "UPDATE Arquivo SET caminhoArquivo = ?, nomeArquivo = ?, filmeRelacionado = ?, estado = ?, idContribuidor = ? WHERE idArquivo = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, arquivo.getCaminhoArquivo());
            stmt.setString(2, arquivo.getNomeArquivo());
            stmt.setString(3, arquivo.getFilmeRelacionado());
            stmt.setBoolean(4, arquivo.isEstado());
            stmt.setDouble(5, arquivo.getContribuidor().getIdUsuario());
            stmt.setLong(6, arquivo.getIdArquivo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long idArquivo) {
        String sql = "DELETE FROM Arquivo WHERE idArquivo = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, idArquivo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
