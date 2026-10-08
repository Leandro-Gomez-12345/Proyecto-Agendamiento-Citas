package co.com.proyectoagendamientocitas.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFechaHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class BloqueoEntidad {

	private UUID id;
	private BarberoEntidad barbero;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFinal;

	public BloqueoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setBarbero(new BarberoEntidad());
		setFechaHoraInicio(UtilFechaHora.FECHA_HORA_DEFECTO);
		setFechaHoraFinal(UtilFechaHora.FECHA_HORA_DEFECTO);
	}

	public BloqueoEntidad(UUID id, BarberoEntidad barbero, LocalDateTime fechaHoraInicio,
			LocalDateTime fechaHoraFinal) {
		setId(id);
		setBarbero(barbero);
		setFechaHoraInicio(fechaHoraInicio);
		setFechaHoraFinal(fechaHoraFinal);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public BarberoEntidad getBarbero() {
		return barbero;
	}

	public void setBarbero(BarberoEntidad barbero) {
		this.barbero = UtilObjeto.esNulo(barbero) ? new BarberoEntidad() : barbero;
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
