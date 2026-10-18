package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import co.com.proyectoagendamientocitas.transversal.excepciones.AgendamientoCitasDatosExcepcion;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilSQL;
import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilUUID;

public abstract class SqlDAO {

	private Connection conexion;

	protected SqlDAO(Connection conexion) {
		setConexion(conexion);
	}

	protected Connection getConexion() {
		return conexion;
	}

	private void setConexion(Connection conexion) {
		UtilSQL.asegurarConexionAbierta(conexion);
		this.conexion = conexion;
	}

	protected void ejecutarActualizacion(final String sql, final String mensajeUsuario, final Object... parametros) {
		try (var sentencia = getConexion().prepareStatement(sql)) {
			asignarParametros(sentencia, Arrays.asList(parametros));
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			throw AgendamientoCitasDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	protected <E> List<E> ejecutarConsulta(final String sql, final List<Object> parametros,
			final MapeadorFila<E> mapeador, final String mensajeUsuario) {
		var resultadosConsulta = new ArrayList<E>();
		try (var sentencia = getConexion().prepareStatement(sql)) {
			asignarParametros(sentencia, parametros);
			try (var resultados = sentencia.executeQuery()) {
				while (resultados.next()) {
					resultadosConsulta.add(mapeador.mapear(resultados));
				}
			}
		} catch (SQLException excepcion) {
			throw AgendamientoCitasDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
		return resultadosConsulta;
	}

	protected static UUID leerUUID(final ResultSet resultados, final String columna) throws SQLException {
		return UtilUUID.convertirAUUID(resultados.getString(columna));
	}

	private static void asignarParametros(final PreparedStatement sentencia, final List<Object> parametros)
			throws SQLException {
		for (int i = 0; i < parametros.size(); i++) {
			sentencia.setObject(i + 1, parametros.get(i));
		}
	}
}
