package co.com.proyectoagendamientocitas.dominio;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public class ClienteDominio {

	private static final String CELULAR_DEFECTO = "0";

	private final UUID id;
	private final String primerNombre;
	private final String segundoNombre;
	private final String primerApellido;
	private final String segundoApellido;
	private final PrefijoCelularDominio prefijoCelular;
	private final String celular;
	private final boolean elNumeroCelularEsCorrecto;
	private final boolean estaVetado;

	private ClienteDominio(Builder builder) {
		this.id = builder.id;
		this.primerNombre = builder.primerNombre;
		this.segundoNombre = builder.segundoNombre;
		this.primerApellido = builder.primerApellido;
		this.segundoApellido = builder.segundoApellido;
		this.prefijoCelular = builder.prefijoCelular;
		this.celular = builder.celular;
		this.elNumeroCelularEsCorrecto = builder.elNumeroCelularEsCorrecto;
		this.estaVetado = builder.estaVetado;
	}

	public static ClienteDominio obtenerValorDefecto(ClienteDominio cliente) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new Builder().build());
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

	public PrefijoCelularDominio getPrefijoCelular() {
		return prefijoCelular;
	}

	public String getCelular() {
		return celular;
	}

	public boolean isElNumeroCelularEsCorrecto() {
		return elNumeroCelularEsCorrecto;
	}

	public boolean isEstaVetado() {
		return estaVetado;
	}

	public static class Builder {

		private UUID id;
		private String primerNombre;
		private String segundoNombre;
		private String primerApellido;
		private String segundoApellido;
		private PrefijoCelularDominio prefijoCelular;
		private String celular;
		private boolean elNumeroCelularEsCorrecto;
		private boolean estaVetado;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			primerNombre = UtilTexto.VACIA;
			segundoNombre = UtilTexto.VACIA;
			primerApellido = UtilTexto.VACIA;
			segundoApellido = UtilTexto.VACIA;
			prefijoCelular = PrefijoCelularDominio.obtenerValorDefecto(null);
			celular = CELULAR_DEFECTO;
			elNumeroCelularEsCorrecto = UtilBooleano.NO;
			estaVetado = UtilBooleano.NO;
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

		public Builder prefijoCelular(PrefijoCelularDominio prefijoCelular) {
			this.prefijoCelular = PrefijoCelularDominio.obtenerValorDefecto(prefijoCelular);
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

		public Builder estaVetado(Boolean estaVetado) {
			this.estaVetado = UtilBooleano.obtenerValorDefecto(estaVetado, UtilBooleano.NO);
			return this;
		}

		public ClienteDominio build() {
			return new ClienteDominio(this);
		}
	}
}
