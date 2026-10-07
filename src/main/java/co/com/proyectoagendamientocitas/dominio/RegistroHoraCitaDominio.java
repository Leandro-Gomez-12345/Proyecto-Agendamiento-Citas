package co.com.proyectoagendamientocitas.dominio;

import java.time.LocalTime;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilHora;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class RegistroHoraCitaDominio {

	private final UUID id;
	private final CitaDominio cita;
	private final TipoRegistroHoraDominio tipoRegistroHora;
	private final LocalTime hora;

	private RegistroHoraCitaDominio(Builder builder) {
		this.id = builder.id;
		this.cita = builder.cita;
		this.tipoRegistroHora = builder.tipoRegistroHora;
		this.hora = builder.hora;
	}

	public UUID getId() {
		return id;
	}

	public CitaDominio getCita() {
		return cita;
	}

	public TipoRegistroHoraDominio getTipoRegistroHora() {
		return tipoRegistroHora;
	}

	public LocalTime getHora() {
		return hora;
	}

	public static class Builder {

		private UUID id;
		private CitaDominio cita;
		private TipoRegistroHoraDominio tipoRegistroHora;
		private LocalTime hora;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cita = CitaDominio.obtenerValorDefecto(null);
			tipoRegistroHora = TipoRegistroHoraDominio.obtenerValorDefecto(null);
			hora = UtilHora.HORA_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder cita(CitaDominio cita) {
			this.cita = CitaDominio.obtenerValorDefecto(cita);
			return this;
		}

		public Builder tipoRegistroHora(TipoRegistroHoraDominio tipoRegistroHora) {
			this.tipoRegistroHora = TipoRegistroHoraDominio.obtenerValorDefecto(tipoRegistroHora);
			return this;
		}

		public Builder hora(LocalTime hora) {
			this.hora = UtilHora.obtenerValorDefecto(hora);
			return this;
		}

		public RegistroHoraCitaDominio build() {
			return new RegistroHoraCitaDominio(this);
		}
	}
}
