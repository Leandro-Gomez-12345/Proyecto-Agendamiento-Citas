package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ActualizarDAO;
import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.entidad.BarberoServicioEntidad;

public interface BarberoServicioDAO extends CrearDAO<BarberoServicioEntidad>, ConsultarDAO<BarberoServicioEntidad, UUID>,
		ActualizarDAO<BarberoServicioEntidad, UUID> {

}
