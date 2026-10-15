package co.com.proyectoagendamientocitas.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFechaHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class PeriodoCierreEntidad {

	private UUID id;
	private SedeEntidad sede;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFinal;
	private String motivo;

	public PeriodoCierreEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setSede(new SedeEntidad());
		setFechaHoraInicio(UtilFechaHora.FECHA_HORA_DEFECTO);
		setFechaHoraFinal(UtilFechaHora.FECHA_HORA_DEFECTO);
		setMotivo(UtilTexto.VACIA);
	}

	public PeriodoCierreEntidad(UUID id, SedeEntidad sede, LocalDateTime fechaHoraInicio,
			LocalDateTime fechaHoraFinal, String motivo) {
		setId(id);
		setSede(sede);
		setFechaHoraInicio(fechaHoraInicio);
		setFechaHoraFinal(fechaHoraFinal);
		setMotivo(motivo);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(SedeEntidad sede) {
		this.sede = UtilObjeto.esNulo(sede) ? new SedeEntidad() : sede;
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

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = UtilTexto.quitarEspaciosEnBlanco(motivo);
	}
}
