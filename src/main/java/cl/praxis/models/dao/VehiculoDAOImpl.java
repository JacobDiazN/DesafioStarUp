package cl.praxis.models.dao;

import cl.praxis.models.db.DataBase;
import cl.praxis.models.dto.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAOImpl implements VehiculoDAO {
    private static final String CREATE_SQL = "INSERT INTO vehiculos (trabajador_id, marca, modelo, año) VALUES (?, ?, ?, ?)";
    private static final String READ_SQL = "SELECT * FROM vehiculos WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE vehiculos SET marca = ?, modelo = ?, año = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM vehiculos WHERE id = ?";
    private static final String GET_ALL_BY_TRABAJADOR_SQL = "SELECT * FROM vehiculos WHERE trabajador_id = ?";

    @Override
    public void create(Vehiculo vehiculo) {
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
            statement.setInt(1, vehiculo.getTrabajadorId());
            statement.setString(2, vehiculo.getMarca());
            statement.setString(3, vehiculo.getModelo());
            statement.setInt(4, vehiculo.getAño());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vehiculo read(int id) {
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(READ_SQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Vehiculo(resultSet.getInt("id"), resultSet.getInt("trabajador_id"), 
                    resultSet.getString("marca"), resultSet.getString("modelo"), 
                    resultSet.getInt("año"), resultSet.getTimestamp("created_at"), 
                    resultSet.getTimestamp("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Vehiculo vehiculo) {
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setString(1, vehiculo.getMarca());
            statement.setString(2, vehiculo.getModelo());
            statement.setInt(3, vehiculo.getAño());
            statement.setInt(4, vehiculo.getId());
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
    public List<Vehiculo> getAllByTrabajadorId(int trabajadorId) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (Connection connection = DataBase.getConnect();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_BY_TRABAJADOR_SQL)) {
            statement.setInt(1, trabajadorId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vehiculo vehiculo = new Vehiculo(resultSet.getInt("id"), resultSet.getInt("trabajador_id"), 
                    resultSet.getString("marca"), resultSet.getString("modelo"), 
                    resultSet.getInt("año"), resultSet.getTimestamp("created_at"), 
                    resultSet.getTimestamp("updated_at"));
                vehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }
}
