package modelo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InmuebleDAO {

    // Crear un inmueble
    public boolean agregarInmueble(Inmueble inmueble) {
        String sql = "INSERT INTO inmueble (tipo, direccion, zona, precio, disponible, imagen_url) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, inmueble.getTipo());
            ps.setString(2, inmueble.getDireccion());
            ps.setString(3, inmueble.getZona());
            ps.setDouble(4, inmueble.getPrecio());
            ps.setBoolean(5, inmueble.isDisponible());
            ps.setString(6, inmueble.getImagenUrl());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        inmueble.setId(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Leer inmueble por id
    public Inmueble obtenerPorId(int id) {
        String sql = "SELECT * FROM inmueble WHERE id = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Inmueble inmueble = new Inmueble();
                    inmueble.setId(rs.getInt("id"));
                    inmueble.setTipo(rs.getString("tipo"));
                    inmueble.setDireccion(rs.getString("direccion"));
                    inmueble.setZona(rs.getString("zona"));
                    inmueble.setPrecio(rs.getDouble("precio"));
                    inmueble.setDisponible(rs.getBoolean("disponible"));
                    inmueble.setImagenUrl(rs.getString("imagen_url"));
                    return inmueble;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Listar todos los inmuebles
    public List<Inmueble> listarTodos() {
        List<Inmueble> lista = new ArrayList<>();
        String sql = "SELECT * FROM inmueble";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Inmueble inmueble = new Inmueble();
                inmueble.setId(rs.getInt("id"));
                inmueble.setTipo(rs.getString("tipo"));
                inmueble.setDireccion(rs.getString("direccion"));
                inmueble.setZona(rs.getString("zona"));
                inmueble.setPrecio(rs.getDouble("precio"));
                inmueble.setDisponible(rs.getBoolean("disponible"));
                inmueble.setImagenUrl(rs.getString("imagen_url"));
                lista.add(inmueble);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Actualizar inmueble
    public boolean actualizarInmueble(Inmueble inmueble) {
        String sql = "UPDATE inmueble SET tipo = ?, direccion = ?, zona = ?, precio = ?, disponible = ?, imagen_url = ? WHERE id = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, inmueble.getTipo());
            ps.setString(2, inmueble.getDireccion());
            ps.setString(3, inmueble.getZona());
            ps.setDouble(4, inmueble.getPrecio());
            ps.setBoolean(5, inmueble.isDisponible());
            ps.setString(6, inmueble.getImagenUrl());
            ps.setInt(7, inmueble.getId());

            int affected = ps.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Eliminar inmueble por id
    public boolean eliminarInmueble(int id) {
        String sql = "DELETE FROM inmueble WHERE id = ?";
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
