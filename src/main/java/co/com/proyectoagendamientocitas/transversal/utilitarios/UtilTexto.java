package co.com.proyectoagendamientocitas.transversal.utilitarios;

public class UtilTexto {
	
	private static UtilTexto INSTANCIA;
	public static String VACIA = "";
	
	private UtilTexto() {}
	
	public static UtilTexto getUtilTexto() {
		
		synchronized (UtilTexto.class) {
			if (UtilObjeto.esNulo(INSTANCIA)) {
				INSTANCIA = new UtilTexto();
			}
		}
		
		return INSTANCIA;
	}
	
	public boolean esNula(String cadena) {
		return UtilObjeto.esNulo(cadena);
	}
	
	public boolean esVacia(String cadena) {
		return VACIA.equals(obtenerValorDefecto(cadena));
	}
	
	public String obtenerValorDefecto(String valor, String valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}
	
	public String obtenerValorDefecto(String valor) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, VACIA);
	}
	
	public String quitarEspaciosEnBlanco(String valor) {
		return obtenerValorDefecto(valor).trim();
	}
	
	public int obtenerLongitudCadena(String valor) {
		return obtenerValorDefecto(valor).length();
	}
	
	public int obtenerLongitudCadena(String valor, boolean quitarEspaciosBlanco) {
		return quitarEspaciosBlanco
				? obtenerLongitudCadena ( quitarEspaciosEnBlanco(valor))
						: obtenerLongitudCadena (valor);
	}
	
	public boolean longitudCadenaEsValida(String valor,int longitudInicial, int longitudFinal,
			boolean quitarEspaciosBlanco) {
		var valorSanitizado = quitarEspaciosBlanco ? quitarEspaciosEnBlanco(valor) : valor;
		
		return obtenerLongitudCadena(valorSanitizado) >= longitudInicial 
				&& obtenerLongitudCadena(valorSanitizado) <= longitudFinal;
	}
}
