package co.com.proyectoagendamientocitas.transversal.utilitarios;

public final class UtilNumero {
	
	public static int CERO = 0;
	
	private UtilNumero() {
		
	}
	
	public static <N extends Number> N obtenerValorDefecto(N valor, N valorDefecto){
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}
	
	public static <N extends Number> Number obtenerValorDefecto(N valor){
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, CERO);
	}
	
	public static <N extends Number> boolean mayorQue(N numeroUno, N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() > obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number> boolean menorQue(N numeroUno, N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() < obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number> boolean mayorIgualQue(N numeroUno, N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() >= obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number> boolean menorIgualQue(N numeroUno, N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() <= obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number> boolean estaEnIntervalo(N valor, N limiteInferior, N limiteSuperior,
	        boolean incluirLimiteInferior, boolean incluirLimiteSuperior) {

	    var cumpleLimiteInferior = incluirLimiteInferior
	            ? mayorIgualQue(valor, limiteInferior)
	            : mayorQue(valor, limiteInferior);

	    var cumpleLimiteSuperior = incluirLimiteSuperior
	            ? menorIgualQue(valor, limiteSuperior)
	            : menorQue(valor, limiteSuperior);

	    return cumpleLimiteInferior && cumpleLimiteSuperior;
	}

	public static <N extends Number> boolean estaEnIntervaloCerrado(N valor, N limiteInferior, N limiteSuperior) {
	    return estaEnIntervalo(valor, limiteInferior, limiteSuperior, true, true);
	}

	public static <N extends Number> boolean estaEnIntervaloAbierto(N valor, N limiteInferior, N limiteSuperior) {
	    return estaEnIntervalo(valor, limiteInferior, limiteSuperior, false, false);
	}

	public static <N extends Number> boolean estaEnIntervaloCerradoPorIzquierda(N valor, N limiteInferior, N limiteSuperior) {
	    return estaEnIntervalo(valor, limiteInferior, limiteSuperior, true, false);
	}

	public static <N extends Number> boolean estaEnIntervaloCerradoPorDerecha(N valor, N limiteInferior, N limiteSuperior) {
	    return estaEnIntervalo(valor, limiteInferior, limiteSuperior, false, true);
	}
}
