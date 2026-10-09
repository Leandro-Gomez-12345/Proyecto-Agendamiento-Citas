package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ActualizarDAO;
import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.entidad.HorarioSedeEntidad;

public interface HorarioSedeDAO extends CrearDAO<HorarioSedeEntidad>, ConsultarDAO<HorarioSedeEntidad, UUID>,
		ActualizarDAO<HorarioSedeEntidad, UUID> {

}
