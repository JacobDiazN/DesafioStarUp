package cl.praxis.models.dao;

import cl.praxis.models.db.DataBase;
import cl.praxis.models.dto.Trabajador;
import cl.praxis.models.dao.TrabajadorDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAOImpl implements TrabajadorDAO {
    private static final String CREATE_SQL = "INSERT INTO trabajadores (nombre, apellido, rol) VALUES (?, ?, ?)";
    private static final String READ_SQL = "SELECT * FROM trabajadores WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE trabajadores SET nombre = ?, apellido = ?, rol = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM trabajadores WHERE id = ?";
    private static final String GET_ALL_SQL = "SELECT * FROM trabajadores";

    @Override
    public void create(Trabajador trabajador) {
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
            statement.setString(1, trabajador.getNombre());
            statement.setString(2, trabajador.getApellido());
            statement.setString(3, trabajador.getRol());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Trabajador read(int id) {
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(READ_SQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Trabajador(resultSet.getInt("id"), resultSet.getString("nombre"), 
                    resultSet.getString("apellido"), resultSet.getString("rol"), 
                    resultSet.getTimestamp("created_at"), resultSet.getTimestamp("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Trabajador trabajador) {
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setString(1, trabajador.getNombre());
            statement.setString(2, trabajador.getApellido());
            statement.setString(3, trabajador.getRol());
            statement.setInt(4, trabajador.getId());
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
    public List<Trabajador> getAll() {
        List<Trabajador> trabajadores = new ArrayList<>();
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_SQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Trabajador trabajador = new Trabajador(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("rol"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at")                        
                );
                trabajadores.add(trabajador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trabajadores;
    }

}
