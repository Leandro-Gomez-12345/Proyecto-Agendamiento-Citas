package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ActualizarDAO;
import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.entidad.ServicioEntidad;

public interface ServicioDAO extends CrearDAO<ServicioEntidad>, ConsultarDAO<ServicioEntidad, UUID>,
		ActualizarDAO<ServicioEntidad, UUID> {

}
