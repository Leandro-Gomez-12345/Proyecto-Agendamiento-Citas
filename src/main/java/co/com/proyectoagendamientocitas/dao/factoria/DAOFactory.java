package co.com.proyectoagendamientocitas.dao.factoria;

import java.sql.Connection;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilSQL;

public abstract class DAOFactory {

	private Connection conexion;

	protected DAOFactory() {
		abrirConexion();
	}

	protected Connection getConexion() {
		return conexion;
	}

	protected void setConexion(Connection conexion) {
		UtilSQL.asegurarConexionValida(conexion);
		this.conexion = conexion;
	}

	protected abstract void abrirConexion();

	public void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}

	public void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	public void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	public void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
	}
}
