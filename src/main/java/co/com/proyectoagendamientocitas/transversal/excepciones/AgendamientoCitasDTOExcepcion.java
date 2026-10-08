package co.com.proyectoagendamientocitas.transversal.excepciones;

import co.com.proyectoagendamientocitas.transversal.excepciones.enums.Capa;

public class AgendamientoCitasDTOExcepcion extends AgendamientoCitasExcepcion {

	private static final long serialVersionUID = -5148230967158402736L;

	private AgendamientoCitasDTOExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DTO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario) {
		return new AgendamientoCitasDTOExcepcion(mensajeUsuario, mensajeUsuario,
				new Exception(mensajeUsuario));
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new AgendamientoCitasDTOExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(mensajeTecnico));
	}

	public static AgendamientoCitasExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new AgendamientoCitasDTOExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
