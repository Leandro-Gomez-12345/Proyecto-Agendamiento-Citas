package co.com.proyectoagendamientocitas.transversal.excepciones;

import co.com.proyectoagendamientocitas.transversal.excepciones.enums.Capa;

public class AgendamientoCitasDominioExcepcion extends AgendamientoCitasExcepcion {

	private static final long serialVersionUID = 1682405937261840573L;

	private AgendamientoCitasDominioExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DOMINIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario) {
		return new AgendamientoCitasDominioExcepcion(mensajeUsuario, mensajeUsuario,
				new Exception(mensajeUsuario));
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new AgendamientoCitasDominioExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(mensajeTecnico));
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new AgendamientoCitasDominioExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
