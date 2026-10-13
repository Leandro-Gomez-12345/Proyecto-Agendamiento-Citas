package co.com.proyectoagendamientocitas.negocio.negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.BloqueoDominio;

public interface BloqueoNegocio {

	BloqueoDominio definirBloqueo(BloqueoDominio datos);

	void eliminarBloqueo(UUID id);

	List<BloqueoDominio> consultarBloqueosPorFecha(BloqueoDominio filtro, LocalDate fecha);

	BloqueoDominio consultarBloqueoPorFechaHora(BloqueoDominio filtro);

	BloqueoDominio editarBloqueo(UUID id, BloqueoDominio datos);
}
