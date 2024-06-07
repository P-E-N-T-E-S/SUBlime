package Legenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LegendaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    public long save(Legenda legenda) {
        String sql = "INSERT INTO Legenda (texto, idioma, prioridade, nota) VALUES (?, ?, ?, ?)";
        long generatedId = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, legenda.getTexto());
            stmt.setString(2, legenda.getIdioma());
            stmt.setInt(3, legenda.getPrioridade());
            stmt.setDouble(4, legenda.getNota());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedId;
    }

    public Legenda findById(long id) {
        String sql = "SELECT * FROM Legenda WHERE id = ?";
        Legenda legenda = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                legenda = new Legenda(
                        rs.getLong("id"),
                        rs.getString("texto"),
                        rs.getString("idioma"),
                        rs.getInt("prioridade"),
                        rs.getDouble("nota")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return legenda;
    }

    public void update(Legenda legenda) {
        String sql = "UPDATE Legenda SET texto = ?, idioma = ?, prioridade = ?, nota = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, legenda.getTexto());
            stmt.setString(2, legenda.getIdioma());
            stmt.setInt(3, legenda.getPrioridade());
            stmt.setDouble(4, legenda.getNota());
            stmt.setLong(5, legenda.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM Legenda WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}