package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class TipoRegistroHoraDominio {

	private final UUID id;
	private final String nombre;

	private TipoRegistroHoraDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
	}

	public static TipoRegistroHoraDominio obtenerValorDefecto(TipoRegistroHoraDominio tipoRegistroHora) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoRegistroHora, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public static class Builder {

		private UUID id;
		private String nombre;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
			return this;
		}

		public TipoRegistroHoraDominio build() {
			return new TipoRegistroHoraDominio(this);
		}
	}
}
