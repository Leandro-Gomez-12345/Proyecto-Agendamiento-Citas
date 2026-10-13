package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;

import co.com.proyectoagendamientocitas.dto.CiudadDTO;

public interface CiudadFachada {

	List<CiudadDTO> consultarCiudades();
}
