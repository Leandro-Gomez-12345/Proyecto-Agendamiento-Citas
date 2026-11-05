package co.com.proyectoagendamientocitas.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import co.com.proyectoagendamientocitas.controlador.respuesta.RespuestaError;
import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasExcepcion;
import co.com.proyectoagendamientocitas.transversal.logger.AgendamientoCitasLogger;

@RestControllerAdvice
public abstract class AbstractRestController {

	private static final AgendamientoCitasLogger logger = AgendamientoCitasLogger.obtener(AbstractRestController.class);

	@ExceptionHandler(AgendamientoCitasExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarAgendamientoCitasException(AgendamientoCitasExcepcion excepcion) {
		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());
		logger.registrarExcepcion(respuesta.getCorrelationId(), excepcion);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> controlarNotReourcerFoundException(NoResourceFoundException excepcion) {
		var respuesta = RespuestaError.crear(CatalogoMensajes.AbstractRestController.RECURSO_NO_EXISTE
				.formatted(excepcion.getResourcePath(), excepcion.getHttpMethod()));
		logger.advertencia("[{}] Recurso {} no existe (método {})", respuesta.getCorrelationId(),
				excepcion.getResourcePath(), excepcion.getHttpMethod());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarException(Exception excepcion) {
		var respuesta = RespuestaError.crear(CatalogoMensajes.AbstractRestController.ERROR_NO_CONTROLADO);
		logger.registrarExcepcion(respuesta.getCorrelationId(), excepcion);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
	}
}
