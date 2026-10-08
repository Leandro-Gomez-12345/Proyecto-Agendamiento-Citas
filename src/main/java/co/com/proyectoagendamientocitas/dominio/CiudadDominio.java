package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class CiudadDominio {

	private UUID id;
	private String nombre;
	private DepartamentoDominio departamento;

	private CiudadDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.departamento = builder.departamento;
	}

	public static CiudadDominio obtenerValorDefecto(CiudadDominio ciudad) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(ciudad, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public DepartamentoDominio getDepartamento() {
		return departamento;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private DepartamentoDominio departamento;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIA;
			departamento = DepartamentoDominio.obtenerValorDefecto(null);
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
			return this;
		}

		public Builder departamento(DepartamentoDominio departamento) {
			this.departamento = DepartamentoDominio.obtenerValorDefecto(departamento);
			return this;
		}

		public CiudadDominio build() {
			return new CiudadDominio(this);
		}
	}
}
