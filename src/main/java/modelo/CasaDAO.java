package modelo;
import java.sql.*;

public class CasaDAO {

    public boolean agregarCasa(Casa casa) {
        String sql = "INSERT INTO casa (id, pisos, garage, num_vehiculos) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, casa.getId()); 
            ps.setInt(2, casa.getPisos());
            ps.setBoolean(3, casa.isGarage());
            ps.setInt(4, casa.getNumVehiculos());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Casa obtenerCasaPorId(int id) {
        String sql = "SELECT c.*, i.tipo, i.direccion, i.zona, i.precio, i.disponible, i.imagen_url " +
                     "FROM casa c INNER JOIN inmueble i ON c.id = i.id WHERE c.id = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Casa casa = new Casa();
                    casa.setId(rs.getInt("id"));
                    casa.setPisos(rs.getInt("pisos"));
                    casa.setGarage(rs.getBoolean("garage"));
                    casa.setNumVehiculos(rs.getInt("num_vehiculos"));
                    return casa;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean actualizarCasa(Casa casa) {
        String sql = "UPDATE casa SET pisos = ?, garage = ?, num_vehiculos = ? WHERE id = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, casa.getPisos());
            ps.setBoolean(2, casa.isGarage());
            ps.setInt(3, casa.getNumVehiculos());
            ps.setInt(4, casa.getId());

            int affected = ps.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarCasa(int id) {
        String sql = "DELETE FROM casa WHERE id = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
