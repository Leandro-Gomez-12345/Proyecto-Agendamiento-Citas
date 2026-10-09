package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ActualizarDAO;
import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.entidad.MultaEntidad;

public interface MultaDAO extends CrearDAO<MultaEntidad>, ConsultarDAO<MultaEntidad, UUID>,
		ActualizarDAO<MultaEntidad, UUID> {

}
