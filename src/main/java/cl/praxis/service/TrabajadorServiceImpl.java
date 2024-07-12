package cl.praxis.service;

import cl.praxis.models.dao.TrabajadorDAO;
import cl.praxis.models.dao.TrabajadorDAOImpl;
import cl.praxis.models.dao.VehiculoDAO;
import cl.praxis.models.dao.VehiculoDAOImpl;
import cl.praxis.models.dto.Trabajador;
import cl.praxis.models.dto.Vehiculo;

import java.util.List;

public class TrabajadorServiceImpl implements TrabajadorService {
    private final TrabajadorDAO trabajadorDAO;
    private final VehiculoDAO vehiculoDAO;

    public TrabajadorServiceImpl() {
        this.trabajadorDAO = new TrabajadorDAOImpl();
        this.vehiculoDAO = new VehiculoDAOImpl();
    }

    @Override
    public List<Trabajador> getAllTrabajadoresConVehiculos() {
        List<Trabajador> trabajadores = trabajadorDAO.getAll();
        for (Trabajador trabajador : trabajadores) {
            List<Vehiculo> vehiculos = vehiculoDAO.getAllByTrabajadorId(trabajador.getId());
            trabajador.setVehiculos(vehiculos);
        }
        return trabajadores;
    }
}


