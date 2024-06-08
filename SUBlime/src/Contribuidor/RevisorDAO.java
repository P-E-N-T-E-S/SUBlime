package Contribuidor;

import java.sql.*;

public class ModeradorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";
    private ContribuidorInterface mediator;

    public ModeradorDAO(ContribuidorInterface mediator) {
        this.mediator = mediator;
    }

    public void save(Moderador moderador) {
        String sql = "INSERT INTO Moderador (idUsuario, nome, email, senha, eModerador) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, moderador.getIdUsuario());
            stmt.setString(2, moderador.getNome());
            stmt.setString(3, moderador.getEmail());
            stmt.setString(4, moderador.getSenha());
            stmt.setBoolean(5, moderador.getEModerador());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Moderador findById(double idUsuario) {
        String sql = "SELECT * FROM Moderador WHERE idUsuario = ?";
        Moderador moderador = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                moderador = new Moderador(
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

        return moderador;
    }

    public void update(Moderador moderador) {
        String sql = "UPDATE Moderador SET nome = ?, email = ?, senha = ?, eModerador = ? WHERE idUsuario = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, moderador.getNome());
            stmt.setString(2, moderador.getEmail());
            stmt.setString(3, moderador.getSenha());
            stmt.setBoolean(4, moderador.getEModerador());
            stmt.setDouble(5, moderador.getIdUsuario());

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