package cl.praxis.models.dao;

import cl.praxis.models.dto.Usuario;

import java.util.List;

public interface UsuarioDAO {
    void create(Usuario usuario);
    Usuario read(int id);
    void update(Usuario usuario);
    void delete(int id);
    List<Usuario> getAll();
    Usuario getByNick(String nick);
}