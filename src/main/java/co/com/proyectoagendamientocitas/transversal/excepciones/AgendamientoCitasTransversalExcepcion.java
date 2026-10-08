package co.com.proyectoagendamientocitas.transversal.excepciones;

import co.com.proyectoagendamientocitas.transversal.excepciones.enums.Capa;

public class AgendamientoCitasTransversalExcepcion extends AgendamientoCitasExcepcion {

	private static final long serialVersionUID = -4395270926304123906L;

	private AgendamientoCitasTransversalExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.TRANSVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario) {
		return new AgendamientoCitasTransversalExcepcion(mensajeUsuario, mensajeUsuario,
				new Exception(mensajeUsuario));
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new AgendamientoCitasTransversalExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(mensajeTecnico));
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new AgendamientoCitasTransversalExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
