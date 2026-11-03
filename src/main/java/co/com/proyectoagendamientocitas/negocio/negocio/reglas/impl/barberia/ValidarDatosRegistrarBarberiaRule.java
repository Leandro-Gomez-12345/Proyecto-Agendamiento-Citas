package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ValidadorAtributos;

public final class ValidarDatosRegistrarBarberiaRule implements Rule<BarberiaDominio> {

	private static final Rule<BarberiaDominio> INSTANCIA = new ValidarDatosRegistrarBarberiaRule();

	private static final String ETIQUETA_TIPO_SOCIEDAD = "tipo de sociedad";

	private ValidarDatosRegistrarBarberiaRule() {

	}

	public static Rule<BarberiaDominio> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(final BarberiaDominio... datos) {
		var barberia = datos[0];

		AsegurarNombreBarberiaValidoRule.obtenerInstancia().ejecutar(barberia.getNombreBarberia());
		ValidadorAtributos.asegurarReferenciaObligatoria(barberia.getTipoSociedad().getId(), ETIQUETA_TIPO_SOCIEDAD);
		AsegurarDenominacionBarberiaValidaRule.obtenerInstancia().ejecutar(barberia.getDenominacion());
		AsegurarNitBarberiaValidoRule.obtenerInstancia().ejecutar(barberia.getNit());
	}
}
