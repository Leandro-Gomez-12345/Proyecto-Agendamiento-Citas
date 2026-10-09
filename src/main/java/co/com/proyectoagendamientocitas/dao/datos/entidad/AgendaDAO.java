package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.entidad.AgendaEntidad;

public interface AgendaDAO extends CrearDAO<AgendaEntidad>, ConsultarDAO<AgendaEntidad, UUID> {

}
