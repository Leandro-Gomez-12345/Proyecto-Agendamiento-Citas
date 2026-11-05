package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Regla;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ValidadorAtributos;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasNegocioExcepcion;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;

public class AsegurarFormatoBarberiaValidoRule implements Regla<BarberiaEntidad> {

	private static final Regla<BarberiaEntidad> INSTANCIA = new AsegurarFormatoBarberiaValidoRule();

	private static final String ETIQUETA_NOMBRE = "nombre de la barbería";
	private static final int LONGITUD_MINIMA_NOMBRE = 2;
	private static final int LONGITUD_MAXIMA_NOMBRE = 50;

	private static final String ETIQUETA_TIPO_SOCIEDAD = "tipo de sociedad";

	private static final String ETIQUETA_DENOMINACION = "denominación";
	private static final int LONGITUD_MINIMA_DENOMINACION = 2;
	private static final int LONGITUD_MAXIMA_DENOMINACION = 117;
	private static final String CARACTERES_PERMITIDOS_DENOMINACION = "^[\\p{L}0-9 .,&'()-]+$";
	private static final String DESCRIPCION_CARACTERES_PERMITIDOS_DENOMINACION = "solo letras (con o sin tilde), números, espacios y los signos . , & - ' ( )";
	private static final String TERMINA_EN_SUFIJO_SOCIEDAD = "(?i)^(.*\\s)?(S\\.?A\\.?S\\.?|S\\.?A\\.?|Ltda\\.?|Limitada)$";

	private static final String ETIQUETA_NIT = "NIT";
	private static final String FORMATO_NIT = "^[0-9]{8,10}-[0-9]$";
	private static final String DESCRIPCION_FORMATO_NIT = "entre 8 y 10 dígitos, un guion (-) y 1 dígito";

	private AsegurarFormatoBarberiaValidoRule() {

	}

	public static Regla<BarberiaEntidad> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(BarberiaEntidad... datos) {
		var barberia = datos[0];

		asegurarNombreValido(barberia.getNombreBarberia());
		ValidadorAtributos.asegurarReferenciaObligatoria(barberia.getTipoSociedad().getId(), ETIQUETA_TIPO_SOCIEDAD);
		asegurarDenominacionValida(barberia.getDenominacion());
		asegurarNitValido(barberia.getNit());
	}

	private static void asegurarNombreValido(String nombreBarberia) {
		ValidadorAtributos.asegurarTexto(nombreBarberia, ETIQUETA_NOMBRE, LONGITUD_MINIMA_NOMBRE,
				LONGITUD_MAXIMA_NOMBRE);
	}

	private static void asegurarDenominacionValida(String denominacion) {
		ValidadorAtributos.asegurarTexto(denominacion, ETIQUETA_DENOMINACION, LONGITUD_MINIMA_DENOMINACION,
				LONGITUD_MAXIMA_DENOMINACION);
		ValidadorAtributos.asegurarFormato(denominacion, ETIQUETA_DENOMINACION, CARACTERES_PERMITIDOS_DENOMINACION,
				DESCRIPCION_CARACTERES_PERMITIDOS_DENOMINACION);
		asegurarQueNoTerminaEnSufijoDeSociedad(denominacion);
	}

	private static void asegurarQueNoTerminaEnSufijoDeSociedad(String denominacion) {
		if (UtilTexto.formatoEsValido(denominacion, TERMINA_EN_SUFIJO_SOCIEDAD)) {
			var mensajeUsuario = CatalogoMensajes.Reglas.ASEGURAR_DENOMINACION_BARBERIA_SIN_SUFIJO_SOCIEDAD;
			throw AgendamientoCitasNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private static void asegurarNitValido(String nit) {
		ValidadorAtributos.asegurarObligatorio(nit, ETIQUETA_NIT);
		ValidadorAtributos.asegurarFormato(nit, ETIQUETA_NIT, FORMATO_NIT, DESCRIPCION_FORMATO_NIT);
	}
}
