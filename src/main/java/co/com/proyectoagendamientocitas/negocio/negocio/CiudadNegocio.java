package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;

import co.com.proyectoagendamientocitas.dominio.CiudadDominio;

public interface CiudadNegocio {

	List<CiudadDominio> consultarCiudades();
}
