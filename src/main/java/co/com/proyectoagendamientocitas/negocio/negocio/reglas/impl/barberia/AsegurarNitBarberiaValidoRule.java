package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ValidadorAtributos;

public final class AsegurarNitBarberiaValidoRule implements Rule<String> {

	private static final Rule<String> INSTANCIA = new AsegurarNitBarberiaValidoRule();

	private static final String ETIQUETA = "NIT";
	private static final int LONGITUD_MINIMA = 10;
	private static final int LONGITUD_MAXIMA = 12;
	private static final String FORMATO = "^[0-9]{8,10}-[0-9]$";
	private static final String DESCRIPCION_FORMATO = "entre 8 y 10 dígitos, un guion (-) y 1 dígito";

	private AsegurarNitBarberiaValidoRule() {

	}

	public static Rule<String> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(final String... datos) {
		var nit = datos[0];

		ValidadorAtributos.asegurarObligatorio(nit, ETIQUETA);
		ValidadorAtributos.asegurarLongitud(nit, ETIQUETA, LONGITUD_MINIMA, LONGITUD_MAXIMA);
		ValidadorAtributos.asegurarFormato(nit, ETIQUETA, FORMATO, DESCRIPCION_FORMATO);
	}
}
