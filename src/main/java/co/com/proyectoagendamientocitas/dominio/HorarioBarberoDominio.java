package co.com.proyectoagendamientocitas.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFecha;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class HorarioBarberoDominio {

	private UUID id;
	private BarberoDominio barbero;
	private HorarioSedeDominio horarioDeLaSede;
	private LocalTime horaInicio;
	private LocalTime horaFinal;
	private LocalDate fechaCreacion;
	private LocalDate fechaDesactivacion;
	private boolean vigente;

	private HorarioBarberoDominio(Builder builder) {
		this.id = builder.id;
		this.barbero = builder.barbero;
		this.horarioDeLaSede = builder.horarioDeLaSede;
		this.horaInicio = builder.horaInicio;
		this.horaFinal = builder.horaFinal;
		this.fechaCreacion = builder.fechaCreacion;
		this.fechaDesactivacion = builder.fechaDesactivacion;
		this.vigente = builder.vigente;
	}

	public static HorarioBarberoDominio obtenerValorDefecto(HorarioBarberoDominio horarioBarbero) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(horarioBarbero, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public BarberoDominio getBarbero() {
		return barbero;
	}

	public HorarioSedeDominio getHorarioDeLaSede() {
		return horarioDeLaSede;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDate getFechaDesactivacion() {
		return fechaDesactivacion;
	}

	public boolean isVigente() {
		return vigente;
	}

	public static class Builder {

		private UUID id;
		private BarberoDominio barbero;
		private HorarioSedeDominio horarioDeLaSede;
		private LocalTime horaInicio;
		private LocalTime horaFinal;
		private LocalDate fechaCreacion;
		private LocalDate fechaDesactivacion;
		private boolean vigente;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			barbero = BarberoDominio.obtenerValorDefecto(null);
			horarioDeLaSede = HorarioSedeDominio.obtenerValorDefecto(null);
			horaInicio = UtilHora.HORA_DEFECTO;
			horaFinal = UtilHora.HORA_DEFECTO;
			fechaCreacion = UtilFecha.FECHA_DEFECTO;
			fechaDesactivacion = UtilFecha.FECHA_DEFECTO;
			vigente = UtilBooleano.SI;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder barbero(BarberoDominio barbero) {
			this.barbero = BarberoDominio.obtenerValorDefecto(barbero);
			return this;
		}

		public Builder horarioDeLaSede(HorarioSedeDominio horarioDeLaSede) {
			this.horarioDeLaSede = HorarioSedeDominio.obtenerValorDefecto(horarioDeLaSede);
			return this;
		}

		public Builder horaInicio(LocalTime horaInicio) {
			this.horaInicio = UtilHora.obtenerValorDefecto(horaInicio);
			return this;
		}

		public Builder horaFinal(LocalTime horaFinal) {
			this.horaFinal = UtilHora.obtenerValorDefecto(horaFinal);
			return this;
		}

		public Builder fechaCreacion(LocalDate fechaCreacion) {
			this.fechaCreacion = UtilFecha.obtenerValorDefecto(fechaCreacion);
			return this;
		}

		public Builder fechaDesactivacion(LocalDate fechaDesactivacion) {
			this.fechaDesactivacion = UtilFecha.obtenerValorDefecto(fechaDesactivacion);
			return this;
		}

		public Builder vigente(Boolean vigente) {
			this.vigente = UtilBooleano.obtenerValorDefecto(vigente, UtilBooleano.SI);
			return this;
		}

		public HorarioBarberoDominio build() {
			return new HorarioBarberoDominio(this);
		}
	}
}
