package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class SedeFestivoDominio {

	private UUID id;
	private SedeDominio sede;
	private FestivoDominio festivo;

	private SedeFestivoDominio(Builder builder) {
		this.id = builder.id;
		this.sede = builder.sede;
		this.festivo = builder.festivo;
	}

	public static SedeFestivoDominio obtenerValorDefecto(SedeFestivoDominio sedeFestivo) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sedeFestivo, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public SedeDominio getSede() {
		return sede;
	}

	public FestivoDominio getFestivo() {
		return festivo;
	}

	public static class Builder {

		private UUID id;
		private SedeDominio sede;
		private FestivoDominio festivo;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			sede = SedeDominio.obtenerValorDefecto(null);
			festivo = FestivoDominio.obtenerValorDefecto(null);
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder sede(SedeDominio sede) {
			this.sede = SedeDominio.obtenerValorDefecto(sede);
			return this;
		}

		public Builder festivo(FestivoDominio festivo) {
			this.festivo = FestivoDominio.obtenerValorDefecto(festivo);
			return this;
		}

		public SedeFestivoDominio build() {
			return new SedeFestivoDominio(this);
		}
	}
}
