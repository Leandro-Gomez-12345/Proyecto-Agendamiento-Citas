package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ActualizarDAO;
import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.entidad.HorarioBarberoEntidad;

public interface HorarioBarberoDAO extends CrearDAO<HorarioBarberoEntidad>, ConsultarDAO<HorarioBarberoEntidad, UUID>,
		ActualizarDAO<HorarioBarberoEntidad, UUID> {

}
