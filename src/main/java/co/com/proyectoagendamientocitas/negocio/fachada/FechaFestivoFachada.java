package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.BarberiaDTO;
import co.com.proyectoagendamientocitas.dto.FechaFestivoDTO;
import co.com.proyectoagendamientocitas.dto.SedeDTO;

public interface FechaFestivoFachada {

	List<FechaFestivoDTO> definirFechaFestivoTodasLasSedes(FechaFestivoDTO datos);

	FechaFestivoDTO definirFechaFestivoSede(FechaFestivoDTO datos);

	List<FechaFestivoDTO> consultarFechasFestivoSede(SedeDTO filtro);

	List<FechaFestivoDTO> consultarFechasFestivoTodasLasSedes(BarberiaDTO filtro);

	FechaFestivoDTO consultarFechaFestivoPorSedeYFecha(FechaFestivoDTO filtro);

	void eliminarFechaFestivoTodasLasSedes(FechaFestivoDTO filtro);

	void eliminarFechaFestivoSede(UUID id);
}
