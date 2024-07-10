package cl.praxis.controllers;

import cl.praxis.models.dao.UsuarioDAO;
import cl.praxis.models.dao.UsuarioDAOImpl;
import cl.praxis.models.dto.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nick = request.getParameter("nick");
        String password = request.getParameter("password");

        Usuario usuario = usuarioDAO.getByNick(nick);
        if (usuario != null && usuario.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("views/home.jsp");
        } else {
            request.setAttribute("mensaje", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }
}


