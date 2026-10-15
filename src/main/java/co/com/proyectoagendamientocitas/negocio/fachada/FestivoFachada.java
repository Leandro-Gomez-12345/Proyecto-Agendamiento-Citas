package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;

import co.com.proyectoagendamientocitas.dto.FestivoDTO;

public interface FestivoFachada {

	List<FestivoDTO> generarFestivosAnio(int anio);

	List<FestivoDTO> actualizarFestivosAnio(int anio);

	List<FestivoDTO> consultarFestivosAnio(int anio);

	FestivoDTO consultarFestivoPorFecha(FestivoDTO filtro);
}
