package cl.praxis.controllers;

import cl.praxis.models.dto.Trabajador;
import cl.praxis.service.TrabajadorService;
import cl.praxis.service.TrabajadorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/mostrarTrabajadores")
public class MostrarTrabajadoresServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final TrabajadorService trabajadorService = new TrabajadorServiceImpl();
    private static final Logger logger = Logger.getLogger(MostrarTrabajadoresServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Trabajador> trabajadores = trabajadorService.getAllTrabajadoresConVehiculos();
            request.setAttribute("trabajadores", trabajadores);
            request.getRequestDispatcher("/views/mostrarTrabajadores.jsp").forward(request, response);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener trabajadores con vehículos", e);
            throw new ServletException("Error al obtener trabajadores con vehículos", e);
        }
    }
}

