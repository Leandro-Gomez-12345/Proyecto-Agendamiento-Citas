package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ActualizarDAO;
import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.dao.datos.EliminarDAO;
import co.com.proyectoagendamientocitas.entidad.BarberoEntidad;

public interface BarberoDAO extends CrearDAO<BarberoEntidad>, ConsultarDAO<BarberoEntidad, UUID>,
		ActualizarDAO<BarberoEntidad, UUID>, EliminarDAO<UUID> {

}
