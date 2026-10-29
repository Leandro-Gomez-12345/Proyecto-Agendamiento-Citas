package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ValidadorAtributos;

public final class AsegurarRazonSocialBarberiaValidaRule implements Rule<String> {

	private static final Rule<String> INSTANCIA = new AsegurarRazonSocialBarberiaValidaRule();

	private static final String ETIQUETA = "razón social";
	private static final int LONGITUD_MINIMA = 6;
	private static final int LONGITUD_MAXIMA = 128;
	private static final String CARACTERES_PERMITIDOS = "^[\\p{L}0-9 .,&'()-]+$";
	private static final String DESCRIPCION_CARACTERES_PERMITIDOS = "solo letras (con o sin tilde), números, espacios y los signos . , & - ' ( )";
	private static final String TERMINACION = "^.+ SAS$";
	private static final String DESCRIPCION_TERMINACION = "el nombre de la empresa, un espacio y la palabra SAS en mayúscula";

	private AsegurarRazonSocialBarberiaValidaRule() {

	}

	public static Rule<String> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(final String... datos) {
		var razonSocial = datos[0];

		ValidadorAtributos.asegurarObligatorio(razonSocial, ETIQUETA);
		ValidadorAtributos.asegurarLongitud(razonSocial, ETIQUETA, LONGITUD_MINIMA, LONGITUD_MAXIMA);
		ValidadorAtributos.asegurarFormato(razonSocial, ETIQUETA, CARACTERES_PERMITIDOS,
				DESCRIPCION_CARACTERES_PERMITIDOS);
		ValidadorAtributos.asegurarFormato(razonSocial, ETIQUETA, TERMINACION, DESCRIPCION_TERMINACION);
	}
}
