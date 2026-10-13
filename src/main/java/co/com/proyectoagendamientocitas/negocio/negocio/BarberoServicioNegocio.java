package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.BarberoServicioDominio;

public interface BarberoServicioNegocio {

	BarberoServicioDominio habilitarServicioBarbero(BarberoServicioDominio datos);

	BarberoServicioDominio ajustarTiemposServicioBarbero(UUID id, BarberoServicioDominio datos);

	List<BarberoServicioDominio> consultarServiciosElegidos(BarberoServicioDominio filtro);

	List<BarberoServicioDominio> consultarServiciosDeBarbero(BarberoServicioDominio filtro);

	void desactivarServicioBarbero(UUID id);

	void reactivarServicioBarbero(UUID id);
}
