package co.com.proyectoagendamientocitas.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFecha;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class HorarioSedeDominio {

	private final UUID id;
	private final SedeDominio sede;
	private final DiaSemanaDominio diaDeLaSemana;
	private final LocalTime horaApertura;
	private final LocalTime horaCierre;
	private final LocalDate fechaCreacion;
	private final LocalDate fechaDesactivacion;
	private final boolean vigente;

	private HorarioSedeDominio(Builder builder) {
		this.id = builder.id;
		this.sede = builder.sede;
		this.diaDeLaSemana = builder.diaDeLaSemana;
		this.horaApertura = builder.horaApertura;
		this.horaCierre = builder.horaCierre;
		this.fechaCreacion = builder.fechaCreacion;
		this.fechaDesactivacion = builder.fechaDesactivacion;
		this.vigente = builder.vigente;
	}

	public static HorarioSedeDominio obtenerValorDefecto(HorarioSedeDominio horarioSede) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(horarioSede, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public SedeDominio getSede() {
		return sede;
	}

	public DiaSemanaDominio getDiaDeLaSemana() {
		return diaDeLaSemana;
	}

	public LocalTime getHoraApertura() {
		return horaApertura;
	}

	public LocalTime getHoraCierre() {
		return horaCierre;
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
		private SedeDominio sede;
		private DiaSemanaDominio diaDeLaSemana;
		private LocalTime horaApertura;
		private LocalTime horaCierre;
		private LocalDate fechaCreacion;
		private LocalDate fechaDesactivacion;
		private boolean vigente;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			sede = SedeDominio.obtenerValorDefecto(null);
			diaDeLaSemana = DiaSemanaDominio.obtenerValorDefecto(null);
			horaApertura = UtilHora.HORA_DEFECTO;
			horaCierre = UtilHora.HORA_DEFECTO;
			fechaCreacion = UtilFecha.FECHA_DEFECTO;
			fechaDesactivacion = UtilFecha.FECHA_DEFECTO;
			vigente = UtilBooleano.SI;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder sede(SedeDominio sede) {
			this.sede = SedeDominio.obtenerValorDefecto(sede);
			return this;
		}

		public Builder diaDeLaSemana(DiaSemanaDominio diaDeLaSemana) {
			this.diaDeLaSemana = DiaSemanaDominio.obtenerValorDefecto(diaDeLaSemana);
			return this;
		}

		public Builder horaApertura(LocalTime horaApertura) {
			this.horaApertura = UtilHora.obtenerValorDefecto(horaApertura);
			return this;
		}

		public Builder horaCierre(LocalTime horaCierre) {
			this.horaCierre = UtilHora.obtenerValorDefecto(horaCierre);
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

		public HorarioSedeDominio build() {
			return new HorarioSedeDominio(this);
		}
	}
}
