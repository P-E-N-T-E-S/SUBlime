package br.com.code.spring.sublime.contribuidor;

import java.sql.*;

public class ContribuidorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    public void save(Contribuidor contribuidor) {
        String sql = "INSERT INTO Contribuidor (idUsuario, nome, email, senha, eModerador) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, contribuidor.getIdUsuario());
            stmt.setString(2, contribuidor.getNome());
            stmt.setString(3, contribuidor.getEmail());
            stmt.setString(4, contribuidor.getSenha());
            stmt.setBoolean(5, contribuidor.getEModerador());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contribuidor findById(double idUsuario) {
        String sql = "SELECT * FROM Contribuidor WHERE idUsuario = ?";
        Contribuidor contribuidor = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                contribuidor = new Contribuidor();
                contribuidor.setIdUsuario(rs.getDouble("idUsuario"));
                contribuidor.setNome(rs.getString("nome"));
                contribuidor.setEmail(rs.getString("email"));
                contribuidor.setSenha(rs.getString("senha"));
                contribuidor.setEModerador(rs.getBoolean("eModerador"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contribuidor;
    }

    public void update(Contribuidor contribuidor) {
        String sql = "UPDATE Contribuidor SET nome = ?, email = ?, senha = ?, eModerador = ? WHERE idUsuario = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contribuidor.getNome());
            stmt.setString(2, contribuidor.getEmail());
            stmt.setString(3, contribuidor.getSenha());
            stmt.setBoolean(4, contribuidor.getEModerador());
            stmt.setDouble(5, contribuidor.getIdUsuario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(double idUsuario) {
        String sql = "DELETE FROM Contribuidor WHERE idUsuario = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, idUsuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}