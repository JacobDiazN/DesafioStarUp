package cl.praxis.controllers;

import cl.praxis.models.dao.UsuarioDAO;
import cl.praxis.models.dao.UsuarioDAOImpl;
import cl.praxis.models.dto.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nick = request.getParameter("nick");
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        int peso = Integer.parseInt(request.getParameter("peso"));

        List<Usuario> usuarios = usuarioDAO.getAll();
        for (Usuario usuario : usuarios) {
            if (usuario.getNick().equals(nick)) {
                request.setAttribute("mensaje", "El usuario ya existe.");
                request.getRequestDispatcher("views/registro.jsp").forward(request, response);
                return;
            }
        }

        Usuario usuario = new Usuario();
        usuario.setNick(nick);
        usuario.setNombre(nombre);
        usuario.setPassword(password);
        usuario.setPeso(peso);

        usuarioDAO.create(usuario);
        response.sendRedirect("views/login.jsp");
    }
}


