package cl.praxis.models.dao;

import cl.praxis.models.dao.UsuarioDAO;
import cl.praxis.models.dto.Usuario;
import cl.praxis.models.db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
    private static final String CREATE_SQL = "INSERT INTO usuarios (nick, nombre, password, peso) VALUES (?, ?, ?, ?)";
    private static final String READ_SQL = "SELECT * FROM usuarios WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE usuarios SET nick = ?, nombre = ?, password = ?, peso = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM usuarios WHERE id = ?";
    private static final String GET_ALL_SQL = "SELECT * FROM usuarios";
    private static final String GET_BY_NICK_SQL = "SELECT * FROM usuarios WHERE nick = ?";

    @Override
    public void create(Usuario usuario) {
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
            statement.setString(1, usuario.getNick());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getPassword());
            statement.setInt(4, usuario.getPeso());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario read(int id) {
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(READ_SQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(resultSet.getInt("id"), resultSet.getString("nick"),
                        resultSet.getString("nombre"), resultSet.getString("password"),
                        resultSet.getInt("peso"), resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Usuario usuario) {
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setString(1, usuario.getNick());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getPassword());
            statement.setInt(4, usuario.getPeso());
            statement.setInt(5, usuario.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_SQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario(resultSet.getInt("id"), resultSet.getString("nick"),
                        resultSet.getString("nombre"), resultSet.getString("password"),
                        resultSet.getInt("peso"), resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Usuario getByNick(String nick) {
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(GET_BY_NICK_SQL)) {
            statement.setString(1, nick);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(resultSet.getInt("id"), resultSet.getString("nick"),
                        resultSet.getString("nombre"), resultSet.getString("password"),
                        resultSet.getInt("peso"), resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
