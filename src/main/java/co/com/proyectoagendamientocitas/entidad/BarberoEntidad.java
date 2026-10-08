package co.com.proyectoagendamientocitas.entidad;

import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilBooleano;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public final class BarberoEntidad {

	private static final String CELULAR_DEFECTO = "0";

	private UUID id;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private PrefijoCelularEntidad prefijo;
	private String celular;
	private boolean elNumeroCelularEsCorrecto;
	private boolean vigente;
	private SedeEntidad sedeDeTrabajo;

	public BarberoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setPrimerNombre(UtilTexto.VACIA);
		setSegundoNombre(UtilTexto.VACIA);
		setPrimerApellido(UtilTexto.VACIA);
		setSegundoApellido(UtilTexto.VACIA);
		setPrefijo(new PrefijoCelularEntidad());
		setCelular(CELULAR_DEFECTO);
		setElNumeroCelularEsCorrecto(UtilBooleano.NO);
		setVigente(UtilBooleano.SI);
		setSedeDeTrabajo(new SedeEntidad());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = UtilTexto.quitarEspaciosEnBlanco(primerNombre);
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = UtilTexto.quitarEspaciosEnBlanco(segundoNombre);
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = UtilTexto.quitarEspaciosEnBlanco(primerApellido);
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = UtilTexto.quitarEspaciosEnBlanco(segundoApellido);
	}

	public PrefijoCelularEntidad getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(PrefijoCelularEntidad prefijo) {
		this.prefijo = UtilObjeto.esNulo(prefijo) ? new PrefijoCelularEntidad() : prefijo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = UtilTexto.quitarEspaciosEnBlanco(UtilTexto.obtenerValorDefecto(celular, CELULAR_DEFECTO));
	}

	public boolean isElNumeroCelularEsCorrecto() {
		return elNumeroCelularEsCorrecto;
	}

	public void setElNumeroCelularEsCorrecto(Boolean elNumeroCelularEsCorrecto) {
		this.elNumeroCelularEsCorrecto = UtilBooleano.obtenerValorDefecto(elNumeroCelularEsCorrecto, UtilBooleano.NO);
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = UtilBooleano.obtenerValorDefecto(vigente, UtilBooleano.SI);
	}

	public SedeEntidad getSedeDeTrabajo() {
		return sedeDeTrabajo;
	}

	public void setSedeDeTrabajo(SedeEntidad sedeDeTrabajo) {
		this.sedeDeTrabajo = UtilObjeto.esNulo(sedeDeTrabajo) ? new SedeEntidad() : sedeDeTrabajo;
	}
}
