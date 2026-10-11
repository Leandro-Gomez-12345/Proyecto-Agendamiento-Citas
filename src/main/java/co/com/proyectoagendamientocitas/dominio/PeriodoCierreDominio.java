package co.com.proyectoagendamientocitas.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFechaHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class PeriodoCierreDominio {

	private UUID id;
	private SedeDominio sede;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFinal;

	private PeriodoCierreDominio(Builder builder) {
		this.id = builder.id;
		this.sede = builder.sede;
		this.fechaHoraInicio = builder.fechaHoraInicio;
		this.fechaHoraFinal = builder.fechaHoraFinal;
	}

	public static PeriodoCierreDominio obtenerValorDefecto(PeriodoCierreDominio periodoCierre) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(periodoCierre, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public SedeDominio getSede() {
		return sede;
	}

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public LocalDateTime getFechaHoraFinal() {
		return fechaHoraFinal;
	}

	public static class Builder {

		private UUID id;
		private SedeDominio sede;
		private LocalDateTime fechaHoraInicio;
		private LocalDateTime fechaHoraFinal;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			sede = SedeDominio.obtenerValorDefecto(null);
			fechaHoraInicio = UtilFechaHora.FECHA_HORA_DEFECTO;
			fechaHoraFinal = UtilFechaHora.FECHA_HORA_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder sede(SedeDominio sede) {
			this.sede = SedeDominio.obtenerValorDefecto(sede);
			return this;
		}

		public Builder fechaHoraInicio(LocalDateTime fechaHoraInicio) {
			this.fechaHoraInicio = UtilFechaHora.obtenerValorDefecto(fechaHoraInicio);
			return this;
		}

		public Builder fechaHoraFinal(LocalDateTime fechaHoraFinal) {
			this.fechaHoraFinal = UtilFechaHora.obtenerValorDefecto(fechaHoraFinal);
			return this;
		}

		public PeriodoCierreDominio build() {
			return new PeriodoCierreDominio(this);
		}
	}
}
