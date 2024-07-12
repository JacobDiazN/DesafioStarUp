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
@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    private UsuarioService usuarioService;

    @Override
    public void init() {
        this.usuarioService = new UsuarioServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nick = request.getParameter("nick");
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        int peso = Integer.parseInt(request.getParameter("peso"));

        Usuario user = new Usuario();
        user.setNick(nick);
        user.setNombre(nombre);
        user.setPassword(password);
        user.setPeso(peso);

        try {
            usuarioService.register(user);
            response.sendRedirect("views/login.jsp");
        } catch (IllegalArgumentException e) {
            response.sendRedirect("views/registro.jsp?error=true");
        }
    }
}

