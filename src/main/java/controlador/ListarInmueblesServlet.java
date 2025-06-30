package controlador;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import modelo.*;

public class ListarInmueblesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Inmueble> lista = new ArrayList<>();

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM inmueble WHERE disponible = 1");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Inmueble i = new Inmueble();
                i.setId(rs.getInt("id"));
                i.setTipo(rs.getString("tipo"));
                i.setDireccion(rs.getString("direccion"));
                i.setZona(rs.getString("zona"));
                i.setPrecio(rs.getDouble("precio"));
                i.setDisponible(rs.getBoolean("disponible"));
                i.setImagenUrl(rs.getString("imagen_url"));
                lista.add(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("inmuebles", lista);
        RequestDispatcher rd = request.getRequestDispatcher("listaInmuebles.jsp");
        rd.forward(request, response);
    }
}
