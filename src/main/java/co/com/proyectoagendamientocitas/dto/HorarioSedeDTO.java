package co.com.proyectoagendamientocitas.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFecha;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class HorarioSedeDTO {

	private UUID id;
	private SedeDTO sede;
	private DiaSemanaDTO diaDeLaSemana;
	private LocalTime horaApertura;
	private LocalTime horaCierre;
	private LocalDate fechaCreacion;
	private LocalDate fechaDesactivacion;
	private boolean vigente;

	public HorarioSedeDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setSede(new SedeDTO());
		setDiaDeLaSemana(new DiaSemanaDTO());
		setHoraApertura(UtilHora.HORA_DEFECTO);
		setHoraCierre(UtilHora.HORA_DEFECTO);
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

	public SedeDTO getSede() {
		return sede;
	}

	public void setSede(SedeDTO sede) {
		this.sede = UtilObjeto.esNulo(sede) ? new SedeDTO() : sede;
	}

	public DiaSemanaDTO getDiaDeLaSemana() {
		return diaDeLaSemana;
	}

	public void setDiaDeLaSemana(DiaSemanaDTO diaDeLaSemana) {
		this.diaDeLaSemana = UtilObjeto.esNulo(diaDeLaSemana) ? new DiaSemanaDTO() : diaDeLaSemana;
	}

	public LocalTime getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(LocalTime horaApertura) {
		this.horaApertura = UtilHora.obtenerValorDefecto(horaApertura);
	}

	public LocalTime getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(LocalTime horaCierre) {
		this.horaCierre = UtilHora.obtenerValorDefecto(horaCierre);
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
