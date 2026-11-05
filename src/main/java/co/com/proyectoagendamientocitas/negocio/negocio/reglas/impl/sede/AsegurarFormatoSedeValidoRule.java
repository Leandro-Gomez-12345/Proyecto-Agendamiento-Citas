package co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.sede;

import co.com.proyectoagendamientocitas.entidad.SedeEntidad;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.Regla;
import co.com.proyectoagendamientocitas.negocio.negocio.reglas.impl.comun.ValidadorAtributos;

public class AsegurarFormatoSedeValidoRule implements Regla<SedeEntidad> {

	private static final Regla<SedeEntidad> INSTANCIA = new AsegurarFormatoSedeValidoRule();

	private static final String ETIQUETA_BARBERIA = "barbería";
	private static final String ETIQUETA_CIUDAD = "ciudad";

	private static final String ETIQUETA_NOMBRE = "nombre de la sede";
	private static final int LONGITUD_MINIMA_NOMBRE = 2;
	private static final int LONGITUD_MAXIMA_NOMBRE = 50;

	private static final String ETIQUETA_DIRECCION = "dirección";
	private static final int LONGITUD_MINIMA_DIRECCION = 5;
	private static final int LONGITUD_MAXIMA_DIRECCION = 100;
	private static final String CARACTERES_PERMITIDOS_DIRECCION = "^[\\p{L}0-9 #-]+$";
	private static final String DESCRIPCION_CARACTERES_PERMITIDOS_DIRECCION = "solo letras (con o sin tilde), números, espacios y los signos # -";

	private AsegurarFormatoSedeValidoRule() {

	}

	public static Regla<SedeEntidad> obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public void ejecutar(SedeEntidad... datos) {
		var sede = datos[0];

		ValidadorAtributos.asegurarReferenciaObligatoria(sede.getBarberia().getId(), ETIQUETA_BARBERIA);
		ValidadorAtributos.asegurarReferenciaObligatoria(sede.getCiudad().getId(), ETIQUETA_CIUDAD);
		asegurarNombreValido(sede.getNombre());
		asegurarDireccionValida(sede.getDireccion());
	}

	private static void asegurarNombreValido(String nombre) {
		ValidadorAtributos.asegurarTexto(nombre, ETIQUETA_NOMBRE, LONGITUD_MINIMA_NOMBRE, LONGITUD_MAXIMA_NOMBRE);
	}

	private static void asegurarDireccionValida(String direccion) {
		ValidadorAtributos.asegurarTexto(direccion, ETIQUETA_DIRECCION, LONGITUD_MINIMA_DIRECCION,
				LONGITUD_MAXIMA_DIRECCION);
		ValidadorAtributos.asegurarFormato(direccion, ETIQUETA_DIRECCION, CARACTERES_PERMITIDOS_DIRECCION,
				DESCRIPCION_CARACTERES_PERMITIDOS_DIRECCION);
	}
}
