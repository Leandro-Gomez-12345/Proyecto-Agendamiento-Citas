package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilNumero;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class ServicioDominio {

	private UUID id;
	private SedeDominio sede;
	private String nombre;
	private String descripcion;
	private int precio;
	private boolean disponible;

	private ServicioDominio(Builder builder) {
		this.id = builder.id;
		this.sede = builder.sede;
		this.nombre = builder.nombre;
		this.descripcion = builder.descripcion;
		this.precio = builder.precio;
		this.disponible = builder.disponible;
	}

	public static ServicioDominio obtenerValorDefecto(ServicioDominio servicio) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(servicio, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public SedeDominio getSede() {
		return sede;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public static class Builder {

		private UUID id;
		private SedeDominio sede;
		private String nombre;
		private String descripcion;
		private int precio;
		private boolean disponible;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			sede = SedeDominio.obtenerValorDefecto(null);
			nombre = UtilTexto.VACIA;
			descripcion = UtilTexto.VACIA;
			precio = UtilNumero.CERO;
			disponible = UtilBooleano.SI;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder sede(SedeDominio sede) {
			this.sede = SedeDominio.obtenerValorDefecto(sede);
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

		public Builder precio(Integer precio) {
			this.precio = UtilNumero.obtenerValorDefecto(precio, UtilNumero.CERO);
			return this;
		}

		public Builder disponible(Boolean disponible) {
			this.disponible = UtilBooleano.obtenerValorDefecto(disponible, UtilBooleano.SI);
			return this;
		}

		public ServicioDominio build() {
			return new ServicioDominio(this);
		}
	}
}
