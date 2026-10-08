package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class EstadoDominio {

	private UUID id;
	private String nombre;
	private String descripcion;

	private EstadoDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.descripcion = builder.descripcion;
	}

	public static EstadoDominio obtenerValorDefecto(EstadoDominio estado) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estado, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private String descripcion;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIA;
			descripcion = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
			return this;
		}

		public Builder descripcion(String descripcion) {
			this.descripcion = UtilTexto.quitarEspaciosEnBlanco(descripcion);
			return this;
		}

		public EstadoDominio build() {
			return new EstadoDominio(this);
		}
	}
}
