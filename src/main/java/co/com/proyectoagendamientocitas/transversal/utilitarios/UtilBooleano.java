package co.com.proyectoagendamientocitas.transversal.utilitarios;

public final class UtilBooleano {
	
	public static final boolean SI = true; 
	public static final boolean NO = false;
 
	private UtilBooleano() {

	}
 
	public static boolean obtenerValorDefecto(final Boolean valor, final boolean valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}
 
	public static boolean esVerdadero(final Boolean valor) {
		return obtenerValorDefecto(valor, SI) == true;
	}
 
	public static boolean esFalso(final Boolean valor) {
		return !esVerdadero(valor);
	}
}