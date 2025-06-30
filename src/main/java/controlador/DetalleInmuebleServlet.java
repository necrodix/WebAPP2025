package controlador;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import modelo.*;

public class DetalleInmuebleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Inmueble inmueble = null;

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM inmueble WHERE id = ?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                inmueble = new Inmueble();
                inmueble.setId(rs.getInt("id"));
                inmueble.setTipo(rs.getString("tipo"));
                inmueble.setDireccion(rs.getString("direccion"));
                inmueble.setZona(rs.getString("zona"));
                inmueble.setPrecio(rs.getDouble("precio"));
                inmueble.setDisponible(rs.getBoolean("disponible"));
                inmueble.setImagenUrl(rs.getString("imagen_url"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("inmueble", inmueble);
        RequestDispatcher rd = request.getRequestDispatcher("detalleInmueble.jsp");
        rd.forward(request, response);
    }
}
