package cl.praxis.service;

import cl.praxis.models.dto.Trabajador;
import java.util.List;

public interface TrabajadorService {
    List<Trabajador> getAllTrabajadoresConVehiculos();
}
