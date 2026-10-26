package co.com.proyectoagendamientocitas.transversal.logger.contexto;

import org.slf4j.MDC;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;

public final class ContextoLog {

	public static final String CLAVE_CORRELATION_ID = "correlationId";

	private ContextoLog() {

	}

	public static void establecerCorrelationId(final String correlationId) {
		if (UtilTexto.esVacia(correlationId)) {
			limpiar();
			return;
		}
		MDC.put(CLAVE_CORRELATION_ID, correlationId);
	}

	public static String obtenerCorrelationId() {
		return UtilTexto.obtenerValorDefecto(MDC.get(CLAVE_CORRELATION_ID));
	}

	public static void limpiar() {
		MDC.remove(CLAVE_CORRELATION_ID);
	}
}
