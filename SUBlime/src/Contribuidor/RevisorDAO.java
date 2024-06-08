package Contribuidor;

import java.sql.*;

public class RevisorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";
    private ContribuidorInterface mediator;

    public RevisorDAO(ContribuidorInterface mediator) {
        this.mediator = mediator;
    }

    public void save(Revisor revisor) {
        String sql = "INSERT INTO Moderador (idUsuario, nome, email, senha, eModerador) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, revisor.getIdUsuario());
            stmt.setString(2, revisor.getNome());
            stmt.setString(3, revisor.getEmail());
            stmt.setString(4, revisor.getSenha());
            stmt.setBoolean(5, revisor.getEModerador());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Revisor findById(double idUsuario) {
        String sql = "SELECT * FROM Moderador WHERE idUsuario = ?";
        Revisor revisor = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                revisor = new Revisor(
                        mediator,
                        rs.getDouble("idUsuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getBoolean("eModerador")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return revisor;
    }

    public void update(Revisor revisor) {
        String sql = "UPDATE Moderador SET nome = ?, email = ?, senha = ?, eModerador = ? WHERE idUsuario = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, revisor.getNome());
            stmt.setString(2, revisor.getEmail());
            stmt.setString(3, revisor.getSenha());
            stmt.setBoolean(4, revisor.getEModerador());
            stmt.setDouble(5, revisor.getIdUsuario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(double idUsuario) {
        String sql = "DELETE FROM Moderador WHERE idUsuario = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, idUsuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}