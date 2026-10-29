package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.BarberiaDTO;
import co.com.proyectoagendamientocitas.dto.SedeDTO;
import co.com.proyectoagendamientocitas.dto.SedeFestivoDTO;

public interface SedeFestivoFachada {

	List<SedeFestivoDTO> definirSedeFestivoTodasLasSedes(SedeFestivoDTO datos);

	SedeFestivoDTO definirSedeFestivoSede(SedeFestivoDTO datos);

	List<SedeFestivoDTO> consultarFechasFestivoSede(SedeDTO filtro);

	List<SedeFestivoDTO> consultarFechasFestivoTodasLasSedes(BarberiaDTO filtro);

	SedeFestivoDTO consultarSedeFestivoPorSedeYFecha(SedeFestivoDTO filtro);

	void eliminarSedeFestivoTodasLasSedes(SedeFestivoDTO filtro);

	void eliminarSedeFestivoSede(UUID id);
}
