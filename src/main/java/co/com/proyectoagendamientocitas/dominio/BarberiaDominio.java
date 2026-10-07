package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class BarberiaDominio {

	private final UUID id;
	private final String nombreBarberia;
	private final String razonSocial;
	private final String nit;

	private BarberiaDominio(Builder builder) {
		this.id = builder.id;
		this.nombreBarberia = builder.nombreBarberia;
		this.razonSocial = builder.razonSocial;
		this.nit = builder.nit;
	}

	public static BarberiaDominio obtenerValorDefecto(BarberiaDominio barberia) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(barberia, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public String getNombreBarberia() {
		return nombreBarberia;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getNit() {
		return nit;
	}

	public static class Builder {

		private UUID id;
		private String nombreBarberia;
		private String razonSocial;
		private String nit;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombreBarberia = UtilTexto.VACIA;
			razonSocial = UtilTexto.VACIA;
			nit = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombreBarberia(String nombreBarberia) {
			this.nombreBarberia = UtilTexto.quitarEspaciosEnBlanco(nombreBarberia);
			return this;
		}

		public Builder razonSocial(String razonSocial) {
			this.razonSocial = UtilTexto.obtenerValorDefecto(razonSocial);
			return this;
		}

		public Builder nit(String nit) {
			this.nit = UtilTexto.quitarEspaciosEnBlanco(nit);
			return this;
		}

		public BarberiaDominio build() {
			return new BarberiaDominio(this);
		}
	}
}
