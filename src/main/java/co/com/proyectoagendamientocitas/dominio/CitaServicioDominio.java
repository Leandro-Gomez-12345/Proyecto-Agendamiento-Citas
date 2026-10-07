package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class CitaServicioDominio {

	private final UUID id;
	private final CitaDominio cita;
	private final BarberoServicioDominio barberoServicio;
	private final int precioServicio;
	private final int duracionEnHorasElServicio;
	private final int duracionEnMinutosElServicio;
	private final int tiempoExtra;

	private CitaServicioDominio(Builder builder) {
		this.id = builder.id;
		this.cita = builder.cita;
		this.barberoServicio = builder.barberoServicio;
		this.precioServicio = builder.precioServicio;
		this.duracionEnHorasElServicio = builder.duracionEnHorasElServicio;
		this.duracionEnMinutosElServicio = builder.duracionEnMinutosElServicio;
		this.tiempoExtra = builder.tiempoExtra;
	}

	public UUID getId() {
		return id;
	}

	public CitaDominio getCita() {
		return cita;
	}

	public BarberoServicioDominio getBarberoServicio() {
		return barberoServicio;
	}

	public int getPrecioServicio() {
		return precioServicio;
	}

	public int getDuracionEnHorasElServicio() {
		return duracionEnHorasElServicio;
	}

	public int getDuracionEnMinutosElServicio() {
		return duracionEnMinutosElServicio;
	}

	public int getTiempoExtra() {
		return tiempoExtra;
	}

	public static class Builder {

		private UUID id;
		private CitaDominio cita;
		private BarberoServicioDominio barberoServicio;
		private int precioServicio;
		private int duracionEnHorasElServicio;
		private int duracionEnMinutosElServicio;
		private int tiempoExtra;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cita = CitaDominio.obtenerValorDefecto(null);
			barberoServicio = BarberoServicioDominio.obtenerValorDefecto(null);
			precioServicio = UtilNumero.CERO;
			duracionEnHorasElServicio = UtilNumero.CERO;
			duracionEnMinutosElServicio = UtilNumero.CERO;
			tiempoExtra = UtilNumero.CERO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder cita(CitaDominio cita) {
			this.cita = CitaDominio.obtenerValorDefecto(cita);
			return this;
		}

		public Builder barberoServicio(BarberoServicioDominio barberoServicio) {
			this.barberoServicio = BarberoServicioDominio.obtenerValorDefecto(barberoServicio);
			return this;
		}

		public Builder precioServicio(Integer precioServicio) {
			this.precioServicio = UtilNumero.obtenerValorDefecto(precioServicio, UtilNumero.CERO);
			return this;
		}

		public Builder duracionEnHorasElServicio(Integer duracionEnHorasElServicio) {
			this.duracionEnHorasElServicio = UtilNumero.obtenerValorDefecto(duracionEnHorasElServicio, UtilNumero.CERO);
			return this;
		}

		public Builder duracionEnMinutosElServicio(Integer duracionEnMinutosElServicio) {
			this.duracionEnMinutosElServicio = UtilNumero.obtenerValorDefecto(duracionEnMinutosElServicio, UtilNumero.CERO);
			return this;
		}

		public Builder tiempoExtra(Integer tiempoExtra) {
			this.tiempoExtra = UtilNumero.obtenerValorDefecto(tiempoExtra, UtilNumero.CERO);
			return this;
		}

		public CitaServicioDominio build() {
			return new CitaServicioDominio(this);
		}
	}
}
