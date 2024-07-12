package cl.praxis.models.dao;

import cl.praxis.models.dto.Vehiculo;

import java.util.List;

public interface VehiculoDAO {
    void create(Vehiculo vehiculo);
    Vehiculo read(int id);
    void update(Vehiculo vehiculo);
    void delete(int id);
    List<Vehiculo> getAllByTrabajadorId(int trabajadorId);
}
