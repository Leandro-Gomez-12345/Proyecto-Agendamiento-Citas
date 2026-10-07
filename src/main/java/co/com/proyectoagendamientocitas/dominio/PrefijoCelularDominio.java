package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class PrefijoCelularDominio {

	private static final String PREFIJO_DEFECTO = "+0";

	private final UUID id;
	private final String prefijo;

	private PrefijoCelularDominio(Builder builder) {
		this.id = builder.id;
		this.prefijo = builder.prefijo;
	}

	public static PrefijoCelularDominio obtenerValorDefecto(PrefijoCelularDominio prefijoCelular) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(prefijoCelular, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public static class Builder {

		private UUID id;
		private String prefijo;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			prefijo = PREFIJO_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder prefijo(String prefijo) {
			this.prefijo = UtilTexto.quitarEspaciosEnBlanco(UtilTexto.obtenerValorDefecto(prefijo, PREFIJO_DEFECTO));
			return this;
		}

		public PrefijoCelularDominio build() {
			return new PrefijoCelularDominio(this);
		}
	}
}
