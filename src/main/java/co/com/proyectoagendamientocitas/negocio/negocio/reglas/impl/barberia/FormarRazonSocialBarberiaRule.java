package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.barberia;

import co.com.proyectoagendamientocitas.entidad.BarberiaEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Rule;

public final class FormarRazonSocialBarberiaRule implements Rule<BarberiaEntidad> {

	private static final Rule<BarberiaEntidad> INSTANCIA = new FormarRazonSocialBarberiaRule();

	private static final String SEPARADOR = " ";

	private FormarRazonSocialBarberiaRule() {

	}

	public static Rule<BarberiaEntidad> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(final BarberiaEntidad... datos) {
		var barberia = datos[0];
		barberia.setRazonSocial(barberia.getDenominacion() + SEPARADOR + barberia.getTipoSociedad().getSufijo());
	}
}
