package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;

import co.com.proyectoagendamientocitas.dominio.TipoMultaDominio;

public interface TipoMultaNegocio {

	List<TipoMultaDominio> consultarTodosLosTiposMulta();
}
