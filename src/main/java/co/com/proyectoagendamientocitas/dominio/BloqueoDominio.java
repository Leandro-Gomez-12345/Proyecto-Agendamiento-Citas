package co.com.proyectoagendamientocitas.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilFechaHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class BloqueoDominio {

	private final UUID id;
	private final BarberoDominio barbero;
	private final LocalDateTime fechaHoraInicio;
	private final LocalDateTime fechaHoraFinal;

	private BloqueoDominio(Builder builder) {
		this.id = builder.id;
		this.barbero = builder.barbero;
		this.fechaHoraInicio = builder.fechaHoraInicio;
		this.fechaHoraFinal = builder.fechaHoraFinal;
	}

	public UUID getId() {
		return id;
	}

	public BarberoDominio getBarbero() {
		return barbero;
	}

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public LocalDateTime getFechaHoraFinal() {
		return fechaHoraFinal;
	}

	public static class Builder {

		private UUID id;
		private BarberoDominio barbero;
		private LocalDateTime fechaHoraInicio;
		private LocalDateTime fechaHoraFinal;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			barbero = BarberoDominio.obtenerValorDefecto(null);
			fechaHoraInicio = UtilFechaHora.FECHA_HORA_DEFECTO;
			fechaHoraFinal = UtilFechaHora.FECHA_HORA_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder barbero(BarberoDominio barbero) {
			this.barbero = BarberoDominio.obtenerValorDefecto(barbero);
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

		public BloqueoDominio build() {
			return new BloqueoDominio(this);
		}
	}
}
