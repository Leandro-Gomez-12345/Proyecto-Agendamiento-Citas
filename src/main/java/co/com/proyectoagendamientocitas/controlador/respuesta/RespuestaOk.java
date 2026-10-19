package co.com.proyectoagendamientocitas.controlador.respuesta;

import java.util.List;

public class RespuestaOk<D> extends Respuesta<D> {

	protected RespuestaOk(List<String> mensajes, List<D> datos) {
		super(mensajes, datos, EstadoRespuesta.OK);
	}
	
	public static <D> RespuestaOk<D> crear(List<String> mensajes, List<D> datos) {
		return new RespuestaOk<>(mensajes, datos);
	}
	
	public static <D> RespuestaOk<D> crear(List<D> datos) {
		return new RespuestaOk<>(List.of(), datos);
	}
	
	public static <D> RespuestaOk<D> crear(D dato) {
		return new RespuestaOk<>(List.of(), List.of(dato));
	}
	
	public static <D> RespuestaOk<D> crear() {
		return new RespuestaOk<>(List.of(), List.of());
	}
	
}
