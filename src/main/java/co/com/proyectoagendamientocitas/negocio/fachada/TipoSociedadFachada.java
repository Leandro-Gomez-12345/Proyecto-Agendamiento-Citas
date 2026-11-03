package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;

import co.com.proyectoagendamientocitas.dto.TipoSociedadDTO;

public interface TipoSociedadFachada {

	List<TipoSociedadDTO> consultarTodosLosTiposSociedad();
}
