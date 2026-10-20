package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ValidadorAtributos;

public final class AsegurarNombreBarberiaValidoRule implements Rule<String> {

	private static final Rule<String> INSTANCIA = new AsegurarNombreBarberiaValidoRule();

	private static final String ETIQUETA = "nombre de la barbería";
	private static final int LONGITUD_MINIMA = 2;
	private static final int LONGITUD_MAXIMA = 50;

	private AsegurarNombreBarberiaValidoRule() {

	}

	public static Rule<String> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(final String... datos) {
		var nombreBarberia = datos[0];

		ValidadorAtributos.asegurarObligatorio(nombreBarberia, ETIQUETA);
		ValidadorAtributos.asegurarLongitud(nombreBarberia, ETIQUETA, LONGITUD_MINIMA, LONGITUD_MAXIMA);
	}
}
