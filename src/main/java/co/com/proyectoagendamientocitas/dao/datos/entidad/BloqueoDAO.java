package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ActualizarDAO;
import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.dao.datos.EliminarDAO;
import co.com.proyectoagendamientocitas.entidad.BloqueoEntidad;

public interface BloqueoDAO extends CrearDAO<BloqueoEntidad>, ConsultarDAO<BloqueoEntidad, UUID>,
		ActualizarDAO<BloqueoEntidad, UUID>, EliminarDAO<UUID> {

}
