package co.com.proyectoagendamientocitas.negocio.fachada;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import co.com.proyectoagendamientocitas.dto.AgendaDTO;
import co.com.proyectoagendamientocitas.dto.CitaDTO;

public interface AgendaFachada {

	AgendaDTO crearAgendaBarbero(AgendaDTO datos);

	List<LocalTime> consultarDisponibilidadBarbero(AgendaDTO filtro);

	List<CitaDTO> consultarCitasDeAgenda(AgendaDTO filtro);

	List<CitaDTO> consultarCitasPorBarberoYRango(AgendaDTO filtro, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinal);
}
