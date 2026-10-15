package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.dominio.FechaFestivoDominio;
import co.com.proyectoagendamientocitas.dominio.SedeDominio;

public interface FechaFestivoNegocio {

	List<FechaFestivoDominio> definirFechaFestivoTodasLasSedes(FechaFestivoDominio datos);

	FechaFestivoDominio definirFechaFestivoSede(FechaFestivoDominio datos);

	List<FechaFestivoDominio> consultarFechasFestivoSede(SedeDominio filtro);

	List<FechaFestivoDominio> consultarFechasFestivoTodasLasSedes(BarberiaDominio filtro);

	FechaFestivoDominio consultarFechaFestivoPorSedeYFecha(FechaFestivoDominio filtro);

	void eliminarFechaFestivoTodasLasSedes(FechaFestivoDominio filtro);

	void eliminarFechaFestivoSede(UUID id);
}
