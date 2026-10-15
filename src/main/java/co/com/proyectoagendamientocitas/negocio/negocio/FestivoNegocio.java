package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;

import co.com.proyectoagendamientocitas.dominio.FestivoDominio;

public interface FestivoNegocio {

	List<FestivoDominio> generarFestivosAnio(int anio);

	List<FestivoDominio> actualizarFestivosAnio(int anio);

	List<FestivoDominio> consultarFestivosAnio(int anio);

	FestivoDominio consultarFestivoPorFecha(FestivoDominio filtro);
}
