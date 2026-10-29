package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun;

import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;

public final class ValidadorAtributos {

	private ValidadorAtributos() {

	}

	public static void asegurarObligatorio(final String valor, final String etiqueta) {
		if (UtilTexto.esVacia(valor)) {
			lanzar(CatalogoMensajes.Reglas.DATO_OBLIGATORIO.formatted(etiqueta));
		}
	}

	public static void asegurarLongitud(final String valor, final String etiqueta, final int longitudMinima,
			final int longitudMaxima) {
		if (!UtilTexto.longitudEsValida(valor, longitudMinima, longitudMaxima)) {
			lanzarLongitudNoValida(etiqueta, longitudMinima, longitudMaxima);
		}
	}

	public static void asegurarLongitudConservandoEspacios(final String valor, final String etiqueta,
			final int longitudMinima, final int longitudMaxima) {
		if (!UtilTexto.longitudEsValidaConservandoEspacios(valor, longitudMinima, longitudMaxima)) {
			lanzarLongitudNoValida(etiqueta, longitudMinima, longitudMaxima);
		}
	}

	public static void asegurarFormato(final String valor, final String etiqueta, final String formato,
			final String descripcionFormato) {
		if (!UtilTexto.formatoEsValido(valor, formato)) {
			lanzar(CatalogoMensajes.Reglas.FORMATO_NO_VALIDO.formatted(etiqueta, descripcionFormato));
		}
	}

	private static void lanzarLongitudNoValida(final String etiqueta, final int longitudMinima,
			final int longitudMaxima) {
		lanzar(CatalogoMensajes.Reglas.LONGITUD_NO_VALIDA.formatted(etiqueta, longitudMinima, longitudMaxima));
	}

	private static void lanzar(final String mensajeUsuario) {
		throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
	}
}
