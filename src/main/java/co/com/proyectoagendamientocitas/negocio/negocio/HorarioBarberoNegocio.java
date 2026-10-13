package co.com.proyectoagendamientocitas.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.dominio.HorarioBarberoDominio;

public interface HorarioBarberoNegocio {

	HorarioBarberoDominio definirHorarioDeTrabajo(HorarioBarberoDominio datos);

	List<HorarioBarberoDominio> consultarHorariosDefinidos(HorarioBarberoDominio filtro);

	void desactivarHorarioDeTrabajo(UUID id);

	List<HorarioBarberoDominio> consultarHorariosDeTrabajoDeBarbero(HorarioBarberoDominio filtro);
}
