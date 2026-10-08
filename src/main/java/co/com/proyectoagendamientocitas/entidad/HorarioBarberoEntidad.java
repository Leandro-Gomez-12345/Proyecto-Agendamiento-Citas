package co.com.proyectoagendamientocitas.entidad;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFecha;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class HorarioBarberoEntidad {

	private UUID id;
	private BarberoEntidad barbero;
	private HorarioSedeEntidad horarioDeLaSede;
	private LocalTime horaInicio;
	private LocalTime horaFinal;
	private LocalDate fechaCreacion;
	private LocalDate fechaDesactivacion;
	private boolean vigente;

	public HorarioBarberoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setBarbero(new BarberoEntidad());
		setHorarioDeLaSede(new HorarioSedeEntidad());
		setHoraInicio(UtilHora.HORA_DEFECTO);
		setHoraFinal(UtilHora.HORA_DEFECTO);
		setFechaCreacion(UtilFecha.FECHA_DEFECTO);
		setFechaDesactivacion(UtilFecha.FECHA_DEFECTO);
		setVigente(UtilBooleano.SI);
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

	public HorarioSedeEntidad getHorarioDeLaSede() {
		return horarioDeLaSede;
	}

	public void setHorarioDeLaSede(HorarioSedeEntidad horarioDeLaSede) {
		this.horarioDeLaSede = UtilObjeto.esNulo(horarioDeLaSede) ? new HorarioSedeEntidad() : horarioDeLaSede;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = UtilHora.obtenerValorDefecto(horaInicio);
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = UtilHora.obtenerValorDefecto(horaFinal);
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = UtilFecha.obtenerValorDefecto(fechaCreacion);
	}

	public LocalDate getFechaDesactivacion() {
		return fechaDesactivacion;
	}

	public void setFechaDesactivacion(LocalDate fechaDesactivacion) {
		this.fechaDesactivacion = UtilFecha.obtenerValorDefecto(fechaDesactivacion);
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = UtilBooleano.obtenerValorDefecto(vigente, UtilBooleano.SI);
	}
}
