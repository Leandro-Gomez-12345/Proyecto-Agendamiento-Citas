package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.EstadoDTO;

public interface EstadoFachada {

	List<EstadoDTO> consultarTodosLosEstados();

	void editarDescripcion(UUID id, EstadoDTO datos);

	String consultarDescripcion(EstadoDTO datos);
}
