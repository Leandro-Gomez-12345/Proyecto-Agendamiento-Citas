package co.com.proyectoagendamientocitas.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFechaHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class BloqueoDTO {

	private UUID id;
	private BarberoDTO barbero;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFinal;

	public BloqueoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setBarbero(new BarberoDTO());
		setFechaHoraInicio(UtilFechaHora.FECHA_HORA_DEFECTO);
		setFechaHoraFinal(UtilFechaHora.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public BarberoDTO getBarbero() {
		return barbero;
	}

	public void setBarbero(BarberoDTO barbero) {
		this.barbero = UtilObjeto.esNulo(barbero) ? new BarberoDTO() : barbero;
	}

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
		this.fechaHoraInicio = UtilFechaHora.obtenerValorDefecto(fechaHoraInicio);
	}

	public LocalDateTime getFechaHoraFinal() {
		return fechaHoraFinal;
	}

	public void setFechaHoraFinal(LocalDateTime fechaHoraFinal) {
		this.fechaHoraFinal = UtilFechaHora.obtenerValorDefecto(fechaHoraFinal);
	}
}
