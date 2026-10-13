package co.com.proyectoagendamientocitas.negocio.negocio;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import co.com.proyectoagendamientocitas.dominio.AgendaDominio;
import co.com.proyectoagendamientocitas.dominio.CitaDominio;

public interface AgendaNegocio {

	AgendaDominio crearAgendaBarbero(AgendaDominio datos);

	List<LocalTime> consultarDisponibilidadBarbero(AgendaDominio filtro);

	List<CitaDominio> consultarCitasDeAgenda(AgendaDominio filtro);

	List<CitaDominio> consultarCitasPorBarberoYRango(AgendaDominio filtro, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinal);
}
