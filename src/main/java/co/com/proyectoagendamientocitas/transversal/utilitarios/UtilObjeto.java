package co.com.proyectoagendamientocitas.transversal.utilitarios;

import java.util.Objects;

public final class UtilObjeto {
	
	private UtilObjeto() {
		
	}
	
	public static <O> boolean esNulo(O objeto) {
		return objeto == null;
	}
	
	public static <O> O obtenerValorDefectoSiValorOriginalEsNulo(O valor, O valorDefecto) {
		return Objects.requireNonNullElse(valor, valorDefecto);
	}
}
