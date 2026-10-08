package co.com.proyectoagendamientocitas.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;

import co.com.proyectoagendamientocitas.transversal.catalogo.CatalogoMensajes;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasExcepcion;
import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasTransversalExcepcion;

public final class UtilSQL {

	private static final int SEGUNDOS_VALIDACION_CONEXION = 5;

	private UtilSQL() {

	}

	public static boolean conexionEstaVacia(final Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}

	public static boolean conexionEstaAbierta(final Connection conexion) {
		try {
			return !conexionEstaVacia(conexion) && !conexion.isClosed();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	public static boolean conexionEsValida(final Connection conexion) {
		try {
			return conexionEstaAbierta(conexion) && conexion.isValid(SEGUNDOS_VALIDACION_CONEXION);
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ES_VALIDA;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	public static void asegurarConexionAbierta(final Connection conexion) {
		if (!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_CONEXION_SQL_NO_ESTA_ABIERTA;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario);
		}
	}

	public static void asegurarConexionValida(final Connection conexion) {
		asegurarConexionAbierta(conexion);
		if (!conexionEsValida(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_CONEXION_SQL_NO_ES_VALIDA;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario);
		}
	}

	public static boolean transaccionEstaIniciada(final Connection conexion) {
		try {
			return conexionEstaAbierta(conexion) && !conexion.getAutoCommit();
		} catch (AgendamientoCitasExcepcion excepcion) {
			throw excepcion;
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	public static void iniciarTransaccion(final Connection conexion) {
		asegurarConexionAbierta(conexion);
		if (transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario);
		}

		try {
			conexion.setAutoCommit(false);
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_INICIANDO_TRANSACCION_SQL;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	public static void confirmarTransaccion(final Connection conexion) {
		asegurarTransaccionIniciada(conexion,
				CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL);

		try {
			conexion.commit();
			conexion.setAutoCommit(true);
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_CONFIRMANDO_TRANSACCION_SQL;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	public static void cancelarTransaccion(final Connection conexion) {
		asegurarTransaccionIniciada(conexion,
				CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL);

		try {
			conexion.rollback();
			conexion.setAutoCommit(true);
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_CANCELANDO_TRANSACCION_SQL;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	public static void cerrarConexion(final Connection conexion) {
		if (!conexionEstaAbierta(conexion)) {
			return;
		}

		try {
			if (transaccionEstaIniciada(conexion)) {
				conexion.rollback();
			}
			conexion.close();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_CERRANDO_CONEXION_SQL;
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	private static void asegurarTransaccionIniciada(final Connection conexion, final String mensajeUsuario) {
		if (!transaccionEstaIniciada(conexion)) {
			throw AgendamientoCitasTransversalExcepcion.crear(mensajeUsuario);
		}
	}
}
