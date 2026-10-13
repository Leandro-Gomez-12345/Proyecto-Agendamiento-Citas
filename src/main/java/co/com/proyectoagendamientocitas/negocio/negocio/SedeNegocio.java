package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.SedeDominio;

public interface SedeNegocio {

	SedeDominio registrarSede(SedeDominio datos);

	SedeDominio consultarDatosSede(UUID id);

	SedeDominio cambiarNombreSede(UUID id, SedeDominio datos);

	SedeDominio cambiarDireccionSede(UUID id, SedeDominio datos);

	void darDeBajaSede(UUID id);
}
