package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ActualizarDAO;
import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.entidad.CitaEntidad;

public interface CitaDAO extends CrearDAO<CitaEntidad>, ConsultarDAO<CitaEntidad, UUID>,
		ActualizarDAO<CitaEntidad, UUID> {

}
