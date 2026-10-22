package co.com.proyectoagendamientocitas.transversal.logger;

import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasExcepcion;
import co.com.proyectoagendamientocitas.transversal.logger.contexto.ContextoLog;

public final class Logger {

	private final AgendamientoCitasLogger logger;

	private Logger(final AgendamientoCitasLogger logger) {
		this.logger = logger;
	}

	public static Logger obtener(final Class<?> clase) {
		return new Logger(AgendamientoCitasLogger.obtener(clase));
	}

	public void debug(final String mensaje, final Object... argumentos) {
		logger.debug(mensaje, argumentos);
	}

	public void info(final String mensaje, final Object... argumentos) {
		logger.info(mensaje, argumentos);
	}

	public void advertencia(final String mensaje, final Object... argumentos) {
		logger.advertencia(mensaje, argumentos);
	}

	public void error(final String mensaje, final Object... argumentos) {
		logger.error(mensaje, argumentos);
	}

	public void printException(final Exception excepcion) {
		if (excepcion instanceof AgendamientoCitasExcepcion excepcionPropia) {
			logger.registrarExcepcion(excepcionPropia);
		} else {
			logger.error("Falla no controlada: {}", excepcion.getMessage(), excepcion);
		}
	}

	public void printException(final String correlationId, final Exception excepcion) {
		var correlationIdAnterior = ContextoLog.obtenerCorrelationId();
		ContextoLog.establecerCorrelationId(correlationId);
		try {
			printException(excepcion);
		} finally {
			ContextoLog.establecerCorrelationId(correlationIdAnterior);
		}
	}
}
