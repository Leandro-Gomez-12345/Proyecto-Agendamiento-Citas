package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.dominio.BarberiaDominio;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;

public final class ValidarDatosRegistrarBarberiaRule implements Rule<BarberiaDominio> {

	private static final Rule<BarberiaDominio> INSTANCIA = new ValidarDatosRegistrarBarberiaRule();

	private ValidarDatosRegistrarBarberiaRule() {

	}

	public static Rule<BarberiaDominio> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(final BarberiaDominio... datos) {
		var barberia = datos[0];

		AsegurarNombreBarberiaValidoRule.obtenerInstancia().ejecutar(barberia.getNombreBarberia());
		AsegurarRazonSocialBarberiaValidaRule.obtenerInstancia().ejecutar(barberia.getRazonSocial());
		AsegurarNitBarberiaValidoRule.obtenerInstancia().ejecutar(barberia.getNit());
	}
}
