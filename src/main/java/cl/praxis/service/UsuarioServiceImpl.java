package cl.praxis.service;
import cl.praxis.models.dao.UsuarioDAO;
import cl.praxis.models.dao.UsuarioDAOImpl;
import cl.praxis.models.dto.Usuario;
import java.util.List;
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    @Override
    public void register(Usuario usuario) {
        if (usuarioDAO.getByNick(usuario.getNick()) == null) {
            usuarioDAO.create(usuario);
        } else {
            throw new IllegalArgumentException("Usuario con ese nick ya existe");
        }
    }

    @Override
    public Usuario getUserById(int id) {
        return usuarioDAO.read(id);
    }

    @Override
    public void updateUser(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    @Override
    public void deleteUser(int id) {
        usuarioDAO.delete(id);
    }

    @Override
    public List<Usuario> getAllUsers() {
        return usuarioDAO.getAll();
    }

    @Override
    public Usuario getUserByNick(String nick) {
        return usuarioDAO.getByNick(nick);
    }
}



