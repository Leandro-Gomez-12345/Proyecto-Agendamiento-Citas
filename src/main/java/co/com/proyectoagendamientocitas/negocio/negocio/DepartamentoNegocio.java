package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;

import co.com.proyectoagendamientocitas.dominio.DepartamentoDominio;

public interface DepartamentoNegocio {

	List<DepartamentoDominio> consultarDepartamentos();
}
