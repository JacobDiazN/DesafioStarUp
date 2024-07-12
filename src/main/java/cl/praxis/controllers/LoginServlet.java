package cl.praxis.controllers;

import cl.praxis.models.dto.Usuario;
import cl.praxis.service.UsuarioService;
import cl.praxis.service.UsuarioServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UsuarioService usuarioService;

    @Override
    public void init() throws ServletException {
        super.init();  // Asegura que se llame al init() de la clase base HttpServlet
        this.usuarioService = new UsuarioServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nick = request.getParameter("nick");
        String password = request.getParameter("password");

        // Verifica que usuarioService no sea nulo antes de usarlo
        if (usuarioService != null) {
            Usuario user = usuarioService.getUserByNick(nick);

            if (user != null && user.getPassword().equals(password)) {
                request.getSession().setAttribute("usuario", user);
                request.getSession().setAttribute("rol", user.getRol());
                response.sendRedirect("views/home.jsp");
            } else {
                response.sendRedirect("views/errorPermisos.jsp?error=true");
            }
        } else {
            throw new ServletException("UsuarioService no ha sido inicializado correctamente.");
        }
    }
}


