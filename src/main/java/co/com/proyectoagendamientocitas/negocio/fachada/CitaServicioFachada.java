package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;

import co.com.proyectoagendamientocitas.dto.CitaServicioDTO;

public interface CitaServicioFachada {

	List<CitaServicioDTO> consultarServiciosDeCita(CitaServicioDTO filtro);

	List<CitaServicioDTO> consultarPrecioDeCadaServicio(CitaServicioDTO filtro);

	CitaServicioDTO crearCitaServicio(CitaServicioDTO datos);
}
