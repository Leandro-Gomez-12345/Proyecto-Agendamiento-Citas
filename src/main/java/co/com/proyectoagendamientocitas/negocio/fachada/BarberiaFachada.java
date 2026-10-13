package co.com.proyectoagendamientocitas.negocio.fachada;

import java.util.UUID;

import co.com.proyectoagendamientocitas.dto.BarberiaDTO;

public interface BarberiaFachada {

	BarberiaDTO registrarBarberia(BarberiaDTO datos);

	String consultarNombreBarberia(UUID id);

	BarberiaDTO consultarRazonSocialYNitBarberia(UUID id);

	BarberiaDTO cambiarNombreBarberia(UUID id, BarberiaDTO datos);

	BarberiaDTO cambiarRazonSocialBarberia(UUID id, BarberiaDTO datos);

	BarberiaDTO cambiarNitBarberia(UUID id, BarberiaDTO datos);

	void darDeBajaBarberia(UUID id);
}
