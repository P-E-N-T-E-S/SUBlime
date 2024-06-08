package Obra;

import Legenda.Arquivo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObraAudioVisualDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    public void save(ObraAudioVisual obra) {
        String sql = "INSERT INTO ObraAudioVisual (idObra, titulo, duracao, diretor, anoLancamento, tipo, nota, prioridade, caminhoLink) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, obra.getIdObra());
            stmt.setString(2, obra.getTitulo());
            stmt.setString(3, obra.getDuracao());
            stmt.setString(4, obra.getDiretor());
            stmt.setInt(5, obra.getAnoLancamento());
            stmt.setString(6, obra.getTipo());
            stmt.setDouble(7, obra.getNota());
            stmt.setInt(8, obra.getPrioridade());
            stmt.setString(9, obra.getCaminhoLink());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObraAudioVisual findById(double idObra) {
        String sql = "SELECT * FROM ObraAudioVisual WHERE idObra = ?";
        ObraAudioVisual obra = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, idObra);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                obra = new ObraAudioVisual(
                        rs.getDouble("idObra"),
                        rs.getString("titulo"),
                        rs.getString("duracao"),
                        rs.getString("diretor"),
                        rs.getInt("anoLancamento"),
                        rs.getString("tipo"),
                        rs.getDouble("nota"),
                        rs.getInt("prioridade"),
                        null,
                        rs.getString("caminhoLink")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obra;
    }

    public void update(ObraAudioVisual obra) {
        String sql = "UPDATE ObraAudioVisual SET titulo = ?, duracao = ?, diretor = ?, anoLancamento = ?, tipo = ?, nota = ?, prioridade = ?, caminhoLink = ? WHERE idObra = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, obra.getTitulo());
            stmt.setString(2, obra.getDuracao());
            stmt.setString(3, obra.getDiretor());
            stmt.setInt(4, obra.getAnoLancamento());
            stmt.setString(5, obra.getTipo());
            stmt.setDouble(6, obra.getNota());
            stmt.setInt(7, obra.getPrioridade());
            stmt.setString(8, obra.getCaminhoLink());
            stmt.setDouble(9, obra.getIdObra());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(double idObra) {
        String sql = "DELETE FROM ObraAudioVisual WHERE idObra = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, idObra);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
