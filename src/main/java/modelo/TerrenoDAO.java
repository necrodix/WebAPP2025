package modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TerrenoDAO {

    public List<Terreno> obtenerTerrenosDisponibles() {
        List<Terreno> lista = new ArrayList<>();

        String sql = "SELECT i.id, i.direccion, i.zona, i.precio, t.pasto " +
                     "FROM inmueble i JOIN terreno t ON i.id = t.id " +
                     "WHERE i.disponible = 1 AND i.tipo = 'terreno'";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Terreno t = new Terreno();
                t.setId(rs.getInt("id"));
                t.setDireccion(rs.getString("direccion"));
                t.setZona(rs.getString("zona"));
                t.setPrecio(rs.getDouble("precio"));
                t.setPasto(rs.getBoolean("pasto"));
                lista.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
