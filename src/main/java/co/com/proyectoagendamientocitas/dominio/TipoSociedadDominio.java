package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class TipoSociedadDominio {

	private UUID id;
	private String nombre;
	private String sufijo;

	private TipoSociedadDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.sufijo = builder.sufijo;
	}

	public static TipoSociedadDominio obtenerValorDefecto(TipoSociedadDominio tipoSociedad) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoSociedad, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getSufijo() {
		return sufijo;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private String sufijo;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIA;
			sufijo = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
			return this;
		}

		public Builder sufijo(String sufijo) {
			this.sufijo = UtilTexto.quitarEspaciosEnBlanco(sufijo);
			return this;
		}

		public TipoSociedadDominio build() {
			return new TipoSociedadDominio(this);
		}
	}
}
