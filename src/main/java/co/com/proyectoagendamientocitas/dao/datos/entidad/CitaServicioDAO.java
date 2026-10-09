package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dao.datos.ConsultarDAO;
import co.com.proyectoagendamientocitas.dao.datos.CrearDAO;
import co.com.proyectoagendamientocitas.entidad.CitaServicioEntidad;

public interface CitaServicioDAO extends CrearDAO<CitaServicioEntidad>, ConsultarDAO<CitaServicioEntidad, UUID> {

}
