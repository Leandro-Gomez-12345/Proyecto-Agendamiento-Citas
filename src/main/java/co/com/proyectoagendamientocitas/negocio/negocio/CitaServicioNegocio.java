package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;

import co.com.proyectoagendamientocitas.dominio.CitaServicioDominio;

public interface CitaServicioNegocio {

	List<CitaServicioDominio> consultarServiciosDeCita(CitaServicioDominio filtro);

	List<CitaServicioDominio> consultarPrecioDeCadaServicio(CitaServicioDominio filtro);

	CitaServicioDominio crearCitaServicio(CitaServicioDominio datos);
}
