package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.EstadoDominio;

public interface EstadoNegocio {

	List<EstadoDominio> consultarTodosLosEstados();

	void editarDescripcion(UUID id, EstadoDominio datos);

	String consultarDescripcion(EstadoDominio datos);
}
