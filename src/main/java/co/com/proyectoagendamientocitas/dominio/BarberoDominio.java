package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class BarberoDominio {

	private static final String CELULAR_DEFECTO = "0";

	private UUID id;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private PrefijoCelularDominio prefijo;
	private String celular;
	private boolean elNumeroCelularEsCorrecto;
	private boolean vigente;
	private SedeDominio sedeDeTrabajo;

	private BarberoDominio(Builder builder) {
		this.id = builder.id;
		this.primerNombre = builder.primerNombre;
		this.segundoNombre = builder.segundoNombre;
		this.primerApellido = builder.primerApellido;
		this.segundoApellido = builder.segundoApellido;
		this.prefijo = builder.prefijo;
		this.celular = builder.celular;
		this.elNumeroCelularEsCorrecto = builder.elNumeroCelularEsCorrecto;
		this.vigente = builder.vigente;
		this.sedeDeTrabajo = builder.sedeDeTrabajo;
	}

	public static BarberoDominio obtenerValorDefecto(BarberoDominio barbero) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(barbero, new Builder().build());
	}

	public UUID getId() {
		return id;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public PrefijoCelularDominio getPrefijo() {
		return prefijo;
	}

	public String getCelular() {
		return celular;
	}

	public boolean isElNumeroCelularEsCorrecto() {
		return elNumeroCelularEsCorrecto;
	}

	public boolean isVigente() {
		return vigente;
	}

	public SedeDominio getSedeDeTrabajo() {
		return sedeDeTrabajo;
	}

	public static class Builder {

		private UUID id;
		private String primerNombre;
		private String segundoNombre;
		private String primerApellido;
		private String segundoApellido;
		private PrefijoCelularDominio prefijo;
		private String celular;
		private boolean elNumeroCelularEsCorrecto;
		private boolean vigente;
		private SedeDominio sedeDeTrabajo;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			primerNombre = UtilTexto.VACIA;
			segundoNombre = UtilTexto.VACIA;
			primerApellido = UtilTexto.VACIA;
			segundoApellido = UtilTexto.VACIA;
			prefijo = PrefijoCelularDominio.obtenerValorDefecto(null);
			celular = CELULAR_DEFECTO;
			elNumeroCelularEsCorrecto = UtilBooleano.NO;
			vigente = UtilBooleano.SI;
			sedeDeTrabajo = SedeDominio.obtenerValorDefecto(null);
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder primerNombre(String primerNombre) {
			this.primerNombre = UtilTexto.quitarEspaciosEnBlanco(primerNombre);
			return this;
		}

		public Builder segundoNombre(String segundoNombre) {
			this.segundoNombre = UtilTexto.quitarEspaciosEnBlanco(segundoNombre);
			return this;
		}

		public Builder primerApellido(String primerApellido) {
			this.primerApellido = UtilTexto.quitarEspaciosEnBlanco(primerApellido);
			return this;
		}

		public Builder segundoApellido(String segundoApellido) {
			this.segundoApellido = UtilTexto.quitarEspaciosEnBlanco(segundoApellido);
			return this;
		}

		public Builder prefijo(PrefijoCelularDominio prefijo) {
			this.prefijo = PrefijoCelularDominio.obtenerValorDefecto(prefijo);
			return this;
		}

		public Builder celular(String celular) {
			this.celular = UtilTexto.quitarEspaciosEnBlanco(UtilTexto.obtenerValorDefecto(celular, CELULAR_DEFECTO));
			return this;
		}

		public Builder elNumeroCelularEsCorrecto(Boolean elNumeroCelularEsCorrecto) {
			this.elNumeroCelularEsCorrecto = UtilBooleano.obtenerValorDefecto(elNumeroCelularEsCorrecto, UtilBooleano.NO);
			return this;
		}

		public Builder vigente(Boolean vigente) {
			this.vigente = UtilBooleano.obtenerValorDefecto(vigente, UtilBooleano.SI);
			return this;
		}

		public Builder sedeDeTrabajo(SedeDominio sedeDeTrabajo) {
			this.sedeDeTrabajo = SedeDominio.obtenerValorDefecto(sedeDeTrabajo);
			return this;
		}

		public BarberoDominio build() {
			return new BarberoDominio(this);
		}
	}
}
