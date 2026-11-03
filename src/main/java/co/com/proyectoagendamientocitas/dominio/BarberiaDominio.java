package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class BarberiaDominio {

	private UUID id;
	private TipoSociedadDominio tipoSociedad;
	private String nombreBarberia;
	private String denominacion;
	private String razonSocial;
	private String nit;

	private BarberiaDominio(Builder builder) {
		this.id = builder.id;
		this.tipoSociedad = builder.tipoSociedad;
		this.nombreBarberia = builder.nombreBarberia;
		this.denominacion = builder.denominacion;
		this.razonSocial = builder.razonSocial;
		this.nit = builder.nit;
	}

	public static BarberiaDominio obtenerValorDefecto(BarberiaDominio barberia) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(barberia, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public TipoSociedadDominio getTipoSociedad() {
		return tipoSociedad;
	}

	public String getNombreBarberia() {
		return nombreBarberia;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getNit() {
		return nit;
	}

	public static class Builder {

		private UUID id;
		private TipoSociedadDominio tipoSociedad;
		private String nombreBarberia;
		private String denominacion;
		private String razonSocial;
		private String nit;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			tipoSociedad = TipoSociedadDominio.obtenerValorDefecto(null);
			nombreBarberia = UtilTexto.VACIA;
			denominacion = UtilTexto.VACIA;
			razonSocial = UtilTexto.VACIA;
			nit = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder tipoSociedad(TipoSociedadDominio tipoSociedad) {
			this.tipoSociedad = TipoSociedadDominio.obtenerValorDefecto(tipoSociedad);
			return this;
		}

		public Builder nombreBarberia(String nombreBarberia) {
			this.nombreBarberia = UtilTexto.quitarEspaciosEnBlanco(nombreBarberia);
			return this;
		}

		public Builder denominacion(String denominacion) {
			this.denominacion = UtilTexto.quitarEspaciosEnBlanco(denominacion);
			return this;
		}

		public Builder razonSocial(String razonSocial) {
			this.razonSocial = UtilTexto.quitarEspaciosEnBlanco(razonSocial);
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
