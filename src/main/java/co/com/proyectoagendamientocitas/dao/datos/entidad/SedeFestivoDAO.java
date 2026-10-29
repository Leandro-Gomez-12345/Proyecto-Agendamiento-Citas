package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.dao.datos.EliminarDAO;
import co.com.proyectoagendamientocitas.entidad.SedeFestivoEntidad;

public interface SedeFestivoDAO extends CrearDAO<SedeFestivoEntidad>, ConsultarDAO<SedeFestivoEntidad, UUID>,
		EliminarDAO<UUID> {

}
