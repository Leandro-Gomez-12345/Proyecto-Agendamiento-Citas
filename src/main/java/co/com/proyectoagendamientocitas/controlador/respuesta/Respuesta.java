package co.com.proyectoagendamientocitas.controlador.respuesta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

class Respuesta<D> {
	
	private LocalDateTime timestamp;
	private String correlationId;
	private List<String> mensajes;
	private List<D> datos;
	private EstadoRespuesta estado;
	
	protected Respuesta(List<String> mensajes, List<D> datos, EstadoRespuesta estado) {
		setMensajes(mensajes);
		setDatos(datos);
		setEstado(estado);
		timestamp = LocalDateTime.now();
		correlationId = UtilUUID.generarComoTexto();
	}

	private void setMensajes(List<String> mensajes) {
		this.mensajes = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(mensajes, new ArrayList<String>());
	}

	private void setDatos(List<D> datos) {
		this.datos = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(datos, new ArrayList<D>());
	}

	private void setEstado(EstadoRespuesta estado) {
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estado, EstadoRespuesta.ERROR);
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public List<String> getMensajes() {
		return mensajes;
	}

	public List<D> getDatos() {
		return datos;
	}

	public EstadoRespuesta getEstado() {
		return estado;
	}

	public String getCorrelationId() {
		return correlationId;
	}
	
}
