package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;

import co.com.proyectoagendamientocitas.dominio.TipoSociedadDominio;

public interface TipoSociedadNegocio {

	List<TipoSociedadDominio> consultarTodosLosTiposSociedad();
}
