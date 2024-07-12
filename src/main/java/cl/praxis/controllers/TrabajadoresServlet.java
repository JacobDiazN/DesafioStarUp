package cl.praxis.controllers;

import cl.praxis.models.dto.Trabajador;
import cl.praxis.models.dto.Usuario;
import cl.praxis.service.TrabajadorService;
import cl.praxis.service.TrabajadorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TrabajadoresServlet")
public class TrabajadoresServlet extends HttpServlet {
    private TrabajadorService trabajadorService;

    @Override
    public void init() {
        this.trabajadorService = new TrabajadorServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

    	    if (usuario != null && "admin".equals(usuario.getRol().getNombre())) {
    	        List<Trabajador> trabajadores = trabajadorService.getAllTrabajadoresConVehiculos();
    	        request.setAttribute("trabajadores", trabajadores);
    	        request.getRequestDispatcher("/views/trabajadores.jsp").forward(request, response);
    	    } else {
    	        request.getRequestDispatcher("/views/errorPermisos.jsp").forward(request, response);
    	    }
    }
}

