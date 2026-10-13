package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.BarberoServicioDTO;

public interface BarberoServicioFachada {

	BarberoServicioDTO habilitarServicioBarbero(BarberoServicioDTO datos);

	BarberoServicioDTO ajustarTiemposServicioBarbero(UUID id, BarberoServicioDTO datos);

	List<BarberoServicioDTO> consultarServiciosElegidos(BarberoServicioDTO filtro);

	List<BarberoServicioDTO> consultarServiciosDeBarbero(BarberoServicioDTO filtro);

	void desactivarServicioBarbero(UUID id);

	void reactivarServicioBarbero(UUID id);
}
