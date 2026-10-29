package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.dominio.SedeDominio;
import co.com.proyectoagendamientocitas.dominio.SedeFestivoDominio;

public interface SedeFestivoNegocio {

	List<SedeFestivoDominio> definirSedeFestivoTodasLasSedes(SedeFestivoDominio datos);

	SedeFestivoDominio definirSedeFestivoSede(SedeFestivoDominio datos);

	List<SedeFestivoDominio> consultarFechasFestivoSede(SedeDominio filtro);

	List<SedeFestivoDominio> consultarFechasFestivoTodasLasSedes(BarberiaDominio filtro);

	SedeFestivoDominio consultarSedeFestivoPorSedeYFecha(SedeFestivoDominio filtro);

	void eliminarSedeFestivoTodasLasSedes(SedeFestivoDominio filtro);

	void eliminarSedeFestivoSede(UUID id);
}
