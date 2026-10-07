package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class BarberoServicioDominio {

	private final UUID id;
	private final BarberoDominio barbero;
	private final ServicioDominio servicio;
	private final int duracionEnHoras;
	private final int duracionEnMinutos;
	private final int tiempoExtra;
	private final boolean vigente;

	private BarberoServicioDominio(Builder builder) {
		this.id = builder.id;
		this.barbero = builder.barbero;
		this.servicio = builder.servicio;
		this.duracionEnHoras = builder.duracionEnHoras;
		this.duracionEnMinutos = builder.duracionEnMinutos;
		this.tiempoExtra = builder.tiempoExtra;
		this.vigente = builder.vigente;
	}

	public static BarberoServicioDominio obtenerValorDefecto(BarberoServicioDominio barberoServicio) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(barberoServicio, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public BarberoDominio getBarbero() {
		return barbero;
	}

	public ServicioDominio getServicio() {
		return servicio;
	}

	public int getDuracionEnHoras() {
		return duracionEnHoras;
	}

	public int getDuracionEnMinutos() {
		return duracionEnMinutos;
	}

	public int getTiempoExtra() {
		return tiempoExtra;
	}

	public boolean isVigente() {
		return vigente;
	}

	public static class Builder {

		private UUID id;
		private BarberoDominio barbero;
		private ServicioDominio servicio;
		private int duracionEnHoras;
		private int duracionEnMinutos;
		private int tiempoExtra;
		private boolean vigente;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			barbero = BarberoDominio.obtenerValorDefecto(null);
			servicio = ServicioDominio.obtenerValorDefecto(null);
			duracionEnHoras = UtilNumero.CERO;
			duracionEnMinutos = UtilNumero.CERO;
			tiempoExtra = UtilNumero.CERO;
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

		public Builder servicio(ServicioDominio servicio) {
			this.servicio = ServicioDominio.obtenerValorDefecto(servicio);
			return this;
		}

		public Builder duracionEnHoras(Integer duracionEnHoras) {
			this.duracionEnHoras = UtilNumero.obtenerValorDefecto(duracionEnHoras, UtilNumero.CERO);
			return this;
		}

		public Builder duracionEnMinutos(Integer duracionEnMinutos) {
			this.duracionEnMinutos = UtilNumero.obtenerValorDefecto(duracionEnMinutos, UtilNumero.CERO);
			return this;
		}

		public Builder tiempoExtra(Integer tiempoExtra) {
			this.tiempoExtra = UtilNumero.obtenerValorDefecto(tiempoExtra, UtilNumero.CERO);
			return this;
		}

		public Builder vigente(Boolean vigente) {
			this.vigente = UtilBooleano.obtenerValorDefecto(vigente, UtilBooleano.SI);
			return this;
		}

		public BarberoServicioDominio build() {
			return new BarberoServicioDominio(this);
		}
	}
}
