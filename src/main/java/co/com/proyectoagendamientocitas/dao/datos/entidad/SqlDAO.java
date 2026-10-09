package co.com.proyectoagendamientocitas.dao.datos.entidad;

import java.sql.Connection;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilSQL;

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
}
