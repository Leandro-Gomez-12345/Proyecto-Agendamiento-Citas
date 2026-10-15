package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.dao.datos.EliminarDAO;
import co.com.proyectoagendamientocitas.entidad.FechaFestivoEntidad;

public interface FechaFestivoDAO extends CrearDAO<FechaFestivoEntidad>, ConsultarDAO<FechaFestivoEntidad, UUID>,
		EliminarDAO<UUID> {

}
