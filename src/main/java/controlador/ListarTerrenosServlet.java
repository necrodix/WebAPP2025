package controlador;

import modelo.TerrenoDAO;
import modelo.Terreno;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListarTerrenosServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TerrenoDAO dao = new TerrenoDAO();
        List<Terreno> terrenos = dao.obtenerTerrenosDisponibles();

        request.setAttribute("terrenos", terrenos);
        RequestDispatcher rd = request.getRequestDispatcher("listaTerrenos.jsp");
        rd.forward(request, response);
    }
}
