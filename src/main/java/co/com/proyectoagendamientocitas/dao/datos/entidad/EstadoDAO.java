package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ActualizarDAO;
import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.entidad.EstadoEntidad;

public interface EstadoDAO extends ConsultarDAO<EstadoEntidad, UUID>, ActualizarDAO<EstadoEntidad, UUID> {

}
