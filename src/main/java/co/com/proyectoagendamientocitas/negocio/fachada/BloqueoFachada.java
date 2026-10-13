package co.com.proyectoagendamientocitas.negocio.fachada;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.BloqueoDTO;

public interface BloqueoFachada {

	BloqueoDTO definirBloqueo(BloqueoDTO datos);

	void eliminarBloqueo(UUID id);

	List<BloqueoDTO> consultarBloqueosPorFecha(BloqueoDTO filtro, LocalDate fecha);

	BloqueoDTO consultarBloqueoPorFechaHora(BloqueoDTO filtro);

	BloqueoDTO editarBloqueo(UUID id, BloqueoDTO datos);
}
