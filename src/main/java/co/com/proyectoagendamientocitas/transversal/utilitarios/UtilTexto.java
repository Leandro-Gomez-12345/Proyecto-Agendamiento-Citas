package co.com.proyectoagendamientocitas.transversal.utilitarios;

import java.util.regex.Pattern;

public final class UtilTexto {

	public static final String VACIA = "";

	private UtilTexto() {
		
	}

	public static boolean esNula(String valor) {
		return UtilObjeto.esNulo(valor);
	}

	public static String obtenerValorDefecto(String valor, String valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}

	public static String obtenerValorDefecto(String valor) {
		return obtenerValorDefecto(valor, VACIA);
	}

	public static String quitarEspaciosEnBlanco( String valor) {
		return obtenerValorDefecto(valor).trim();
	}

	public static boolean esVacia(String valor) {
		return quitarEspaciosEnBlanco(valor).isEmpty();
	}

	public static boolean esVaciaConservandoEspacios(String valor) {
		return obtenerValorDefecto(valor).isEmpty();
	}

	public static int obtenerLongitud(String valor) {
		return quitarEspaciosEnBlanco(valor).length();
	}

	public static int obtenerLongitudConservandoEspacios(String valor) {
		return obtenerValorDefecto(valor).length();
	}

	public static boolean longitudEsValida(String valor, int longitudMinima,
			final int longitudMaxima) {
		return UtilNumero.estaEnIntervaloCerrado(obtenerLongitud(valor), longitudMinima, longitudMaxima);
	}

	public static boolean longitudEsValidaConservandoEspacios(String valor, int longitudMinima,
			final int longitudMaxima) {
		return UtilNumero.estaEnIntervaloCerrado(obtenerLongitudConservandoEspacios(valor), longitudMinima,
				longitudMaxima);
	}

	public static boolean cumpleFormato(String valor, Pattern formato) {
		return formato.matcher(quitarEspaciosEnBlanco(valor)).matches();
	}
}
