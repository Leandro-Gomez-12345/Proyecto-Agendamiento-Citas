package co.com.proyectoagendamientocitas.transversal.excepciones;

import co.com.proyectoagendamientocitas.transversal.excepciones.enums.Capa;

public class AgendamientoCitasNegocioExcepcion extends AgendamientoCitasExcepcion {

	private static final long serialVersionUID = 4419847105324618925L;

	private AgendamientoCitasNegocioExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.NEGOCIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario) {
		return new AgendamientoCitasNegocioExcepcion(mensajeUsuario, mensajeUsuario,
				new Exception(mensajeUsuario));
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new AgendamientoCitasNegocioExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(mensajeTecnico));
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new AgendamientoCitasNegocioExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
