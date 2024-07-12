package cl.praxis.service;

import cl.praxis.models.dto.Usuario;
import java.util.List;

public interface UsuarioService {
    void register(Usuario usuario);
    Usuario getUserById(int id);
    void updateUser(Usuario usuario);
    void deleteUser(int id);
    List<Usuario> getAllUsers();
    Usuario getUserByNick(String nick);
}