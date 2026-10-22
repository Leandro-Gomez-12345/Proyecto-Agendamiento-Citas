package co.com.proyectoagendamientocitas.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import co.com.proyectoagendamientocitas.controlador.respuesta.RespuestaError;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasExcepcion;
import co.com.proyectoagendamientocitas.transversal.logger.Logger;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

@RestControllerAdvice
public abstract class AbstractRestController {
	
	private static final Logger logger = Logger.obtener(AbstractRestController.class);
	
	@ExceptionHandler(AgendamientoCitasExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarAgendamientoCitasException(AgendamientoCitasExcepcion excepcion) {
		var correlationId = UtilUUID.generarComoTexto();
		var mensajeRespuesta = "Se ha presentado tratando de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion y entreguele el codigo: "
				.concat(correlationId);
		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());
		logger.printException(correlationId, excepcion);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> controlarNotReourcerFoundException(NoResourceFoundException excepcion) {
		var correlationId = UtilUUID.generarComoTexto();
		var mensajeRespuesta = "El recurso que se pidió no existe..." + excepcion.getResourcePath()
		+ " por el metodo " + excepcion.getHttpMethod();
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		logger.advertencia("[{}] Recurso {} no existe (método {})", correlationId, excepcion.getResourcePath(),
				excepcion.getHttpMethod());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarException(Exception excepcion) {
		var correlationId = UtilUUID.generarComoTexto();
		var mensajeRespuesta = "Se ha presentado tratando de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion y entreguelo "
				.concat(correlationId);
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		logger.printException(correlationId, excepcion);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
	}
}
