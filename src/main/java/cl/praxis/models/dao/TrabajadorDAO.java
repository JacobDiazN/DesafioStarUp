package cl.praxis.models.dao;

import cl.praxis.models.dto.Trabajador;

import java.util.List;

public interface TrabajadorDAO {
    void create(Trabajador trabajador);
    Trabajador read(int id);
    void update(Trabajador trabajador);
    void delete(int id);
    List<Trabajador> getAll();
}
