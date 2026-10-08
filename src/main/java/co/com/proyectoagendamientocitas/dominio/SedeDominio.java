package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class SedeDominio {

	private UUID id;
	private CiudadDominio ciudad;
	private BarberiaDominio barberia;
	private String nombre;
	private String direccion;

	private SedeDominio(Builder builder) {
		this.id = builder.id;
		this.ciudad = builder.ciudad;
		this.barberia = builder.barberia;
		this.nombre = builder.nombre;
		this.direccion = builder.direccion;
	}

	public static SedeDominio obtenerValorDefecto(SedeDominio sede) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sede, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public CiudadDominio getCiudad() {
		return ciudad;
	}

	public BarberiaDominio getBarberia() {
		return barberia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public static class Builder {

		private UUID id;
		private CiudadDominio ciudad;
		private BarberiaDominio barberia;
		private String nombre;
		private String direccion;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			ciudad = CiudadDominio.obtenerValorDefecto(null);
			barberia = BarberiaDominio.obtenerValorDefecto(null);
			nombre = UtilTexto.VACIA;
			direccion = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder ciudad(CiudadDominio ciudad) {
			this.ciudad = CiudadDominio.obtenerValorDefecto(ciudad);
			return this;
		}

		public Builder barberia(BarberiaDominio barberia) {
			this.barberia = BarberiaDominio.obtenerValorDefecto(barberia);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
			return this;
		}

		public Builder direccion(String direccion) {
			this.direccion = UtilTexto.quitarEspaciosEnBlanco(direccion);
			return this;
		}

		public SedeDominio build() {
			return new SedeDominio(this);
		}
	}
}
