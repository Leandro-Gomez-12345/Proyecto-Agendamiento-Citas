package co.com.proyectoagendamientocitas.transversal.logger;

import java.util.EnumSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasExcepcion;
import co.com.proyectoagendamientocitas.transversal.excepciones.enums.Capa;
import co.com.proyectoagendamientocitas.transversal.logger.contexto.ContextoLog;

public final class AgendamientoCitasLogger {

	private static final Set<Capa> CAPAS_CON_FALLAS_ESPERADAS = EnumSet.of(Capa.NEGOCIO);

	private final Logger logger;

	private AgendamientoCitasLogger(final Logger logger) {
		this.logger = logger;
	}

	public static AgendamientoCitasLogger obtener(final Class<?> clase) {
		return new AgendamientoCitasLogger(LoggerFactory.getLogger(clase));
	}

	public void debug(final String mensaje, final Object... argumentos) {
		logger.debug(mensaje, argumentos);
	}

	public void info(final String mensaje, final Object... argumentos) {
		logger.info(mensaje, argumentos);
	}

	public void advertencia(final String mensaje, final Object... argumentos) {
		logger.warn(mensaje, argumentos);
	}

	public void error(final String mensaje, final Object... argumentos) {
		logger.error(mensaje, argumentos);
	}

	public void registrarExcepcion(final Exception excepcion) {
		if (excepcion instanceof AgendamientoCitasExcepcion excepcionPropia) {
			registrarExcepcionPropia(excepcionPropia);
		} else {
			error("Falla no controlada: {}", excepcion.getMessage(), excepcion);
		}
	}

	public void registrarExcepcion(final String correlationId, final Exception excepcion) {
		var correlationIdAnterior = ContextoLog.obtenerCorrelationId();
		ContextoLog.establecerCorrelationId(correlationId);
		try {
			registrarExcepcion(excepcion);
		} finally {
			ContextoLog.establecerCorrelationId(correlationIdAnterior);
		}
	}

	private void registrarExcepcionPropia(final AgendamientoCitasExcepcion excepcion) {
		if (CAPAS_CON_FALLAS_ESPERADAS.contains(excepcion.getCapa())) {
			advertencia("Regla incumplida en la capa {}: {}", excepcion.getCapa(), excepcion.getMensajeTecnico());
		} else {
			error("Falla en la capa {}: {}", excepcion.getCapa(), excepcion.getMensajeTecnico(), excepcion);
		}
	}
}
