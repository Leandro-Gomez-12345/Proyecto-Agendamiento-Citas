package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.SedeDTO;

public interface SedeFachada {

	SedeDTO registrarSede(SedeDTO datos);

	SedeDTO consultarDatosSede(UUID id);

	SedeDTO cambiarNombreSede(UUID id, SedeDTO datos);

	SedeDTO cambiarDireccionSede(UUID id, SedeDTO datos);

	void darDeBajaSede(UUID id);
}
