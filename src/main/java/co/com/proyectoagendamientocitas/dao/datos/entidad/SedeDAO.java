package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ActualizarDAO;
import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.dao.datos.EliminarDAO;
import co.com.proyectoagendamientocitas.entidad.SedeEntidad;

public interface SedeDAO extends CrearDAO<SedeEntidad>, ConsultarDAO<SedeEntidad, UUID>,
		ActualizarDAO<SedeEntidad, UUID>, EliminarDAO<UUID> {

}
