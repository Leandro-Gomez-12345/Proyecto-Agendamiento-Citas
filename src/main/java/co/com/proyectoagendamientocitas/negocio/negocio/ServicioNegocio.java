package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.dominio.SedeDominio;
import co.com.proyectoagendamientocitas.dominio.ServicioDominio;

public interface ServicioNegocio {

	List<ServicioDominio> definirServicioTodasLasSedes(ServicioDominio datos);

	ServicioDominio definirServicioSede(ServicioDominio datos);

	List<ServicioDominio> editarServicioTodasLasSedes(ServicioDominio filtro, ServicioDominio datos);

	ServicioDominio editarServicioSede(UUID id, ServicioDominio datos);

	List<ServicioDominio> consultarServiciosSede(SedeDominio filtro);

	List<ServicioDominio> consultarServiciosTodasLasSedes(BarberiaDominio filtro);

	void retirarServicioTodasLasSedes(ServicioDominio filtro);

	void retirarServicioSede(UUID id);

	void reactivarServicioTodasLasSedes(ServicioDominio filtro);

	void reactivarServicioSede(UUID id);

	List<ServicioDominio> consultarServiciosNoDisponiblesSede(SedeDominio filtro);
}
