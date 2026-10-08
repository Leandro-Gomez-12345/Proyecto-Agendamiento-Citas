package co.com.proyectoagendamientocitas.transversal.excepciones;

import co.com.proyectoagendamientocitas.transversal.excepciones.enums.Capa;

public class AgendamientoCitasControladorExcepcion extends AgendamientoCitasExcepcion {

	private static final long serialVersionUID = -2873914502836749051L;

	private AgendamientoCitasControladorExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.CONTROLADOR, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario) {
		return new AgendamientoCitasControladorExcepcion(mensajeUsuario, mensajeUsuario,
				new Exception(mensajeUsuario));
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new AgendamientoCitasControladorExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(mensajeTecnico));
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new AgendamientoCitasControladorExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
