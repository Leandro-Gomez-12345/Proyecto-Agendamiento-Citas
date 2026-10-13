package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.BarberoDominio;
import co.com.proyectoagendamientocitas.dominio.ServicioDominio;

public interface BarberoNegocio {

	BarberoDominio registrarBarbero(BarberoDominio datos);

	BarberoDominio editarContactoBarbero(UUID id, BarberoDominio datos);

	BarberoDominio consultarDatosBarbero(UUID id);

	void desactivarBarbero(UUID id);

	void reactivarBarbero(UUID id);

	BarberoDominio cambiarSedeDeTrabajoBarbero(UUID id, BarberoDominio datos);

	List<ServicioDominio> consultarServiciosSedeBarbero(UUID id);

	void eliminarBarbero(UUID id);
}
