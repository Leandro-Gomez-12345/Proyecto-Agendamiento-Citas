package co.com.proyectoagendamientocitas.transversal.excepciones;

import co.com.proyectoagendamientocitas.transversal.excepciones.enums.Capa;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilObjeto;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;

public class AgendamientoCitasExcepcion extends RuntimeException {

	private static final long serialVersionUID = 3055991330257068511L;

	private Capa capa;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private Exception excepcionRaiz;

	protected AgendamientoCitasExcepcion(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(UtilTexto.obtenerValorDefecto(mensajeTecnico, UtilTexto.obtenerValorDefecto(mensajeUsuario)),
				excepcionRaiz);
		setCapa(capa);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
		setExcepcionRaiz(excepcionRaiz);
	}

	public Capa getCapa() {
		return capa;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public Exception getExcepcionRaiz() {
		return excepcionRaiz;
	}

	private void setCapa(Capa capa) {
		this.capa = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(capa, Capa.GENERAL);
	}

	private void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.obtenerValorDefecto(mensajeUsuario);
	}

	private void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = UtilTexto.obtenerValorDefecto(mensajeTecnico, this.mensajeUsuario);
	}

	private void setExcepcionRaiz(Exception excepcionRaiz) {
		this.excepcionRaiz = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(excepcionRaiz,
				new Exception(this.mensajeTecnico));
	}
}
