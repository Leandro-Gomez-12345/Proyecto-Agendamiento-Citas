package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ValidadorAtributos;

public final class AsegurarRazonSocialBarberiaValidaRule implements Rule<String> {

	private static final Rule<String> INSTANCIA = new AsegurarRazonSocialBarberiaValidaRule();

	private static final String ETIQUETA = "razón social";
	private static final int LONGITUD_MINIMA = 10;
	private static final int LONGITUD_MAXIMA = 50;

	private AsegurarRazonSocialBarberiaValidaRule() {

	}

	public static Rule<String> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(final String... datos) {
		var razonSocial = datos[0];

		ValidadorAtributos.asegurarObligatorio(razonSocial, ETIQUETA);
		ValidadorAtributos.asegurarLongitudConservandoEspacios(razonSocial, ETIQUETA, LONGITUD_MINIMA,
				LONGITUD_MAXIMA);
	}
}
