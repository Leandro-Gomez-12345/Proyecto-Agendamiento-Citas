package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ValidadorAtributos;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;

public final class AsegurarDenominacionBarberiaValidaRule implements Rule<String> {

	private static final Rule<String> INSTANCIA = new AsegurarDenominacionBarberiaValidaRule();

	private static final String ETIQUETA = "denominación";
	private static final int LONGITUD_MINIMA = 2;
	private static final int LONGITUD_MAXIMA = 117;
	private static final String CARACTERES_PERMITIDOS = "^[\\p{L}0-9 .,&'()-]+$";
	private static final String DESCRIPCION_CARACTERES_PERMITIDOS = "solo letras (con o sin tilde), números, espacios y los signos . , & - ' ( )";
	private static final String TERMINA_EN_SUFIJO_SOCIEDAD = "(?i)^(.*\\s)?(S\\.?A\\.?S\\.?|S\\.?A\\.?|Ltda\\.?|Limitada)$";

	private AsegurarDenominacionBarberiaValidaRule() {

	}

	public static Rule<String> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(final String... datos) {
		var denominacion = datos[0];

		ValidadorAtributos.asegurarObligatorio(denominacion, ETIQUETA);
		ValidadorAtributos.asegurarLongitud(denominacion, ETIQUETA, LONGITUD_MINIMA, LONGITUD_MAXIMA);
		ValidadorAtributos.asegurarFormato(denominacion, ETIQUETA, CARACTERES_PERMITIDOS,
				DESCRIPCION_CARACTERES_PERMITIDOS);
		asegurarQueNoTerminaEnSufijoDeSociedad(denominacion);
	}

	private static void asegurarQueNoTerminaEnSufijoDeSociedad(final String denominacion) {
		if (UtilTexto.formatoEsValido(denominacion, TERMINA_EN_SUFIJO_SOCIEDAD)) {
			var mensajeUsuario = CatalogoMensajes.Reglas.ASEGURAR_DENOMINACION_BARBERIA_SIN_SUFIJO_SOCIEDAD;
			throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
